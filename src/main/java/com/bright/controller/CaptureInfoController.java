package com.bright.controller;

import com.bright.entity.ResultEntity;
import com.bright.entity.ResultTemplate;
import com.bright.req.MatchDto;
import com.bright.service.CaptureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

/**
 * 爬虫，获取信息
 *
 * @author wangliang
 * @date 2022/10/4 21:05
 */
@Api(tags = "抓取信息")
@RestController
@RequestMapping("/captureInfo")
public class CaptureInfoController {
    private static final Logger logger = LoggerFactory.getLogger(CaptureInfoController.class);

    @Value("${football.url}")
    private String net;

    /**
     * 比赛名称
     */
    private static String[] matches = new String[]{
            "法甲",
            "意甲",
            "德甲",
            "英超",
            "西甲",
            "欧洲杯",
            "欧冠",
            "世界杯"
    };

    @Autowired
    private CaptureService captureService;



    /**
     * 获取比赛信息，保存到数据库
     *
     * @param matchName 比赛名称
     */
    @PostMapping("/save")
    @ApiOperation("获取实时信息")
    public ResultEntity saveInfo (String matchName) {
        if (StringUtils.isBlank(matchName)) {
            return ResultTemplate.fail("比赛名称不可为空");
        }
        try {
            Document doc = Jsoup.connect(net).get();
            Elements elementsByClass = doc.getElementsByClass("league-qt");
            int size = elementsByClass.size();
            String matchUrl = null;
            for (int i = 0; i < size; i++) {
                Elements lg = elementsByClass.get(i).getElementsByClass("lg");
                for (Element element : lg) {
                    // 匹配到需要寻找的，拿到解析路径，
                    if (element.toString().contains(matchName)) {
                        // a标签
                        Elements a = element.getElementsByTag("a");
                        for (Element aElement : a) {
                            if (aElement.toString().contains(matchName)) {
                                String target = aElement.toString().replaceAll("\"", "");
                                int i1 = target.indexOf("href=");
                                int i2 = target.indexOf("target=");
                                matchUrl = target.substring(i1 + 5, i2-1);
                            }
                        }
                    }
                }
            }
            if (StringUtils.isBlank(matchUrl)) {
                return ResultTemplate.fail("根据比赛名称未查询到相关信息");
            }
            // 获取到地址
            Document targetDoc = Jsoup.connect(matchUrl).get();
            Elements cup = targetDoc.getElementsByClass("cup");
//            for ()
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        return ResultTemplate.success("success");
    }

    @PostMapping("/saveMatchInfo")
    @ApiOperation("保存比赛信息（暂时只适用没有打比赛的世界杯）")
    public ResultEntity getMatchInfo(String match, String level) {
        return captureService.saveMatchInfo(match, level);
    }

    @PostMapping("/saveResult")
    @ApiOperation("寻找比赛结果并存入数据库")
    public ResultEntity saveResult(@Valid @RequestBody MatchDto match) {
        return captureService.saveResult(match);
    }

    @GetMapping("/change")
    public ResultEntity change (){return captureService.change();}
}
