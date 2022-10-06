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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.*;

/**
 * @author wangliang
 * @date 2022/10/5 17:30
 */
@Service
public class CaptureServiceImpl implements CaptureService {
    private Logger logger = LoggerFactory.getLogger(CaptureServiceImpl.class);

    @Value("${football.url}")
    private String net;

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
        if (StringUtils.isBlank(match.getTime()) && StringUtils.isBlank(match.getYear())) {
            return ResultTemplate.fail("比赛具体时间和年份不能同时为空");
        }
        // 1. 根据时间、主客队 找到对应比赛，找到对应比赛名称，war_id
        if (StringUtils.isNotBlank(match.getTime())) {
            Match matchByCondition = matchService.selectByTimeAndTeam(match.getTime(), match.getHost(), match.getGuest());
            if (matchByCondition != null) {
                if (matchByCondition.getFinallyResults() != null) {
                    // 证明比赛已经记录到数据库中
                    return ResultTemplate.success("比赛已经记录到数据库中");
                }
            }
            // 2. 根据对应war_id 找对应url （情况一：所有信息都没有记录到数据库； 情况二：只是比赛结果没有记录到数据库）
            WarInfo warInfo = warInfoService.getWarInfoByName(match.getWarName());
            if (warInfo == null || StringUtils.isBlank(warInfo.getUrl())) {
                try {
                    Document doc = Jsoup.connect(net).get();
                    Elements elementsByClass = doc.getElementsByClass("league-qt");
                    int size = elementsByClass.size();
                    String matchUrl = null;
                    for (int i = 0; i < size; i++) {
                        Elements lg = elementsByClass.get(i).getElementsByClass("lg");
                        for (Element element : lg) {
                            // 匹配到需要寻找的，拿到解析路径，
                            if (element.toString().contains(warInfo.getName())) {
                                // a标签
                                Elements a = element.getElementsByTag("a");
                                for (Element aElement : a) {
                                    if (aElement.toString().contains(warInfo.getName())) {
                                        String target = aElement.toString().replaceAll("\"", "");
                                        int i1 = target.indexOf("href=");
                                        int i2 = target.indexOf("target=");
                                        matchUrl = target.substring(i1 + 5, i2 - 1);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (StringUtils.isBlank(matchUrl)) {
                        return ResultTemplate.fail("根据比赛名称未查询到相关信息");
                    }
                    warInfo.setUrl(matchUrl);
                    warInfoService.updateWar(warInfo);
                } catch (IOException e) {
                    logger.error(e.toString());
                }
            }
            // 3. 获取信息
            try {
                Document doc = Jsoup.connect(warInfo.getUrl()).get();
                Elements cup = doc.getElementsByClass("cup");
                Element cupElement = cup.get(0);
                Map<String, String> warMap = new HashMap();
                Elements groupElements = cupElement.getElementsByTag("ul").get(0).getElementsByTag("li");
                for (int i = 0; i < groupElements.size(); i++) {
                    String s = groupElements.get(i).toString();
                    int i1 = s.indexOf("fl=");
                    int i2 = s.indexOf("\">");
                    String key = s.substring(i1 + 4, i2);
                    int i3 = s.indexOf("</li");
                    String value = s.substring(i2 + 2, i3);
                    // 地址为key，分组赛，半决赛等为value
                    warMap.put(key, value);
                }
                if (!CollectionUtils.isEmpty(warMap)) {
                    Set<Map.Entry<String, String>> entries = warMap.entrySet();
                    for (Map.Entry<String, String> entry : entries) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        Element elementById = cupElement.getElementById("div_" + key);
                        // 找到具体的比赛信息
                        Elements tr = elementById.getElementsByTag("tr");
                        int size = tr.size();
                        for (int i = 1; i < size; i++) {
                            // 从第二个开始
                            Elements td = tr.get(i).getElementsByTag("td");
                            Match saveMatch = new Match();
                            // 主队
                            Element hostElement = td.get(1);
                            String host = hostElement.childNode(0).childNode(0).toString();
                            saveMatch.setNationOne(host);
                            // 客队
                            String guest = td.get(3).childNode(0).childNode(0).toString();
                            saveMatch.setNationTwo(guest);
                            // 判断主队、客队是否和入参相同
                            if (match.getHost().equals(host) && match.getGuest().equals(guest)) {
                                if (td.size() > 6) {
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
                                    saveMatch.setWarName(value);
                                    removeNull(saveMatch);
                                    // 插入 match表
                                    matchService.saveMatch(saveMatch);
                                    return ResultTemplate.success("success");
                                } else {
                                    saveMatch.setWarId(warInfo.getWarId());
                                    saveMatch.setWarName(value);
                                    saveMatch.setMatchId(match1.getWarId());
                                    removeNull(saveMatch);
                                    matchService.updateMatch(saveMatch);
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                logger.error(e.toString());
            }
            // 4. 有的话更新，没有的话新增
        }
        return ResultTemplate.fail("未查询到比赛信息");
    }

    @Override
    public ResultEntity change() {
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

    /**
     * 去除空字符
     *
     * @param match 实体类
     */
    private void removeNull(Match match) {
        if (StringUtils.isNotBlank(match.getNationOne())) {
            match.setNationOne(match.getNationOne().replaceAll(" ", ""));
        }
        if (StringUtils.isNotBlank(match.getNationTwo())) {
            match.setNationTwo(match.getNationTwo().replaceAll(" ", ""));
        }
        if (StringUtils.isNotBlank(match.getHalfCourt())) {
            match.setHalfCourt(match.getHalfCourt().replaceAll(" ", ""));
        }
        if (StringUtils.isNotBlank(match.getFinallyResults())) {
            match.setFinallyResults(match.getFinallyResults().replaceAll(" ", ""));
        }
        if (StringUtils.isNotBlank(match.getConcedeCount())) {
            match.setConcedeCount(match.getConcedeCount().replaceAll(" ", ""));
        }
    }
}
