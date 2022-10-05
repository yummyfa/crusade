package com.bright.service.impl;

import com.bright.entity.Match;
import com.bright.entity.ResultEntity;
import com.bright.entity.ResultTemplate;
import com.bright.entity.WarInfo;
import com.bright.req.MatchDto;
import com.bright.service.CaptureService;
import com.bright.service.MatchService;
import com.bright.service.WarInfoService;
import com.bright.service.WarMatchService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangliang
 * @date 2022/10/5 17:30
 */
@Service
public class CaptureServiceImpl implements CaptureService {
    private Logger logger = LoggerFactory.getLogger(CaptureServiceImpl.class);

    @Autowired
    private MatchService matchService;

    @Autowired
    private WarMatchService warMatchService;

    @Autowired
    private WarInfoService warInfoService;

    /**
     * 保存比赛信息
     *
     * @param match 比赛名称
     * @param level 比赛等级 （小组赛，半决赛等）
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public ResultEntity saveMatchInfo(String match, String level) {
        if (StringUtils.isBlank(match)) {
            return ResultTemplate.fail("比赛名称不可为空");
        }
        if (StringUtils.isBlank(level)) {
            return ResultTemplate.fail("比赛等级不可为空");
        }
        // 1. 先查询到具体的比赛
        WarInfo warInfo = warInfoService.getWarInfoByName(match);
        if (warInfo != null && StringUtils.isNotBlank(warInfo.getUrl())) {
            // 2. 爬虫
            try {
                Document doc = Jsoup.connect(warInfo.getUrl()).get();
                Elements cup = doc.getElementsByClass("cup");
                Element cupElement = cup.get(0);
                // 找的东西在第一个里面
                Elements elementsByTag = cupElement.getElementsByTag("ul").get(0).getElementsByTag("li");
                List<String> flList = new ArrayList();
                String prefix = null;
                for (Element element : elementsByTag) {
                    if (element.toString().contains(level)) {
                        String fl = null;
                        String fl1 = element.toString();
                        int i = fl1.indexOf("fl");
                        int i1 = fl1.indexOf("class=");
                        if (i1 == -1) {
                            i1 = fl1.lastIndexOf("\"");
                            fl = fl1.substring(i + 4, i1);
                        } else {
                            fl = fl1.substring(i + 4, i1 - 2);
                        }
                        prefix = fl;
                    }
                }
                Elements groupElements = cupElement.getElementsByTag("ul").get(1).getElementsByTag("li");
                if (groupElements.size() > 1) {
                    for (int i = 1; i < groupElements.size(); i++) {
                        String s = groupElements.get(i).toString();
                        int i1 = s.indexOf("id=");
                        int i2 = s.indexOf("\">");
                        String substring = s.substring(i1 + 4, i2);
                        flList.add(substring);
                    }
                } else {
                    flList.add(prefix);
                }
                if (!CollectionUtils.isEmpty(flList)) {
                    for (String fl : flList) {
                        Element elementById = cupElement.getElementById("div_" + fl);
                        // 找到具体的比赛信息
                        Elements tr = elementById.getElementsByTag("tr");
                        int size = tr.size();
                        for (int i = 1; i < size; i++) {
                            // 从第二个开始
                            Elements td = tr.get(i).getElementsByTag("td");
                            Match saveMatch = new Match();
                            if (td.size() > 7) {
                                // 比赛已经结束, 设置时间、主队、客队
                                setProperties(td, saveMatch);
                                // 最后比分
                                String finallyResult = td.get(2).childNode(0).toString();
                                saveMatch.setFinallyResults(finallyResult);
                                // 半场
                                String halfCourt = td.get(4).childNode(0).toString();
                                saveMatch.setHalfCourt(halfCourt);
                                // 让球
                                String concedeCount = td.get(5).childNode(0).toString();
                                saveMatch.setConcedeCount(concedeCount);
                                // 分析暂时不做
                            } else {
                                // 比赛还未开始， 设置时间、主队、客队
                                setProperties(td, saveMatch);
                            }
                            // 查询这条记录是否已经存入数据库
                            Match match1 = matchService.selectByTimeAndTeam(saveMatch.getBjTime(), saveMatch.getNationOne(),
                                    saveMatch.getNationTwo());
                            if (match1 == null) {
                                saveMatch.setWarId(warInfo.getWarId());
                                saveMatch.setWarName(level);
                                // 插入 match表
                                matchService.saveMatch(saveMatch);
                                return ResultTemplate.success("success");
                            }
                        }
                    }
                }
            } catch (IOException e) {
                logger.error(e.toString());
                throw new RuntimeException();
            }
        }
        return ResultTemplate.fail("未查询到比赛信息");
    }

    @Override
    public ResultEntity saveResult(MatchDto match) {
        // 1. 根据时间、主客队 找到对应比赛，找到对应比赛名称，war_id
        // 2. 根据对应war_id 找对应url
        // 3. 获取信息
        // 4. 有的话更新，没有的话新增
        return null;
    }

    /**
     * 设置时间、主队、客队
     */
    private void setProperties(Elements td, Match saveMatch) {
        Element timeElement = td.get(0);
        String time = timeElement.childNode(0).toString();
        saveMatch.setBjTime(time);
        // 主队
        Element hostElement = td.get(1);
        String host = hostElement.childNode(0).childNode(0).toString();
        saveMatch.setNationOne(host);
        // 客队
        String guest = td.get(3).childNode(0).childNode(0).toString();
        saveMatch.setNationTwo(guest);
    }
}
