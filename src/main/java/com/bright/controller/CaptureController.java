package com.bright.controller;

import com.bright.entity.League;
import com.bright.entity.ResultEntity;
import com.bright.entity.ResultTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @Author: wangliang
 * @Date: 2021/11/13 18:05
 */
@Api(tags = "获取信息")
@RestController
@RequestMapping("/capture")
public class CaptureController {

    private static String[] match = new String[] {
            "法甲",
            "意甲",
            "德甲",
            "英超",
            "西甲",
            "欧洲杯",
            "欧冠",
            "世界杯"
    };

    private static final Logger logger = LoggerFactory.getLogger(CaptureController.class);

    @GetMapping("/getRealTime")
    @ApiOperation("获取实时信息")
    public ResultEntity<Boolean> getData() {
        try {
                Document doc = Jsoup.connect("https://trade.500.com/jczq/").get();
            Elements elementsByClass = doc.getElementsByClass("bet-tb-tr");
            int count = elementsByClass.size();
            // 判断是否是五大联赛、欧洲杯、欧冠、世界杯
            for (int i = 0; i < 10; i++) {
                Elements elementsByClass1 = elementsByClass.get(i).getElementsByClass("td-evt");
                String s = elementsByClass1.toString().replaceAll("\"", "");
                int i1 = s.indexOf(">");
                int i2 = s.indexOf("</a>");
                String substring = s.substring(i1 + 1, i2);
                int i3 = substring.indexOf(">");
                String match = substring.substring(i3 + 1);
                boolean validEnum = isContains(match);
                if (validEnum){
                    // 获取其他信息
                    Elements elm2 = elementsByClass.get(i).getElementsByClass("team-l");
                    String s2 = elm2.get(1).toString().replaceAll("\"", "");
                    int l1 = s2.indexOf(">");
                    int l2 = s2.indexOf("</a>");
                    String lTeam = s2.substring(l1 + 1, l2);
                    Elements elm3 = elementsByClass.get(i).getElementsByClass("team-r");
                    String s3 = elm3.get(1).toString().replaceAll("\"", "");
                    int r1 = s3.indexOf(">");
                    int r2 = s3.indexOf("</a>");
                    String rTeam = s3.substring(r1 + 1, r2);
                    String split = elementsByClass.get(i).toString();
                    String s1 = split.replaceAll("\"", "");
                    int i4 = s1.indexOf("data-id=");
                    String substring1 = s1.substring(i4);
                    String dataId = substring1.substring(s1.indexOf("=")-1 , substring1.indexOf("data-homeid")-1);
                    Document doc1 = Jsoup.connect("https://odds.500.com/fenxi/stat-"+ dataId +".shtml").get();
                    Elements odds_content = doc1.getElementsByClass("team-tb");
                    boolean door = odds_content.get(0).toString().contains("门");
                    if (door){
                        // 获取球员信息
                    }

                }
            }
            Elements elementsByClass1 = elementsByClass.get(0).getElementsByClass("team-l");
            // 获取字
            Elements h1 = elementsByClass.get(0).getElementsByTag("h1");
            Set<String> strings = doc.classNames();
            Elements elementsByAttribute = doc.select("div").get(72).getAllElements().get(1).getElementsByAttribute("src");

            doc.select("sidebar-box gallery-list").attr("_blank", "jsoup");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultTemplate.successData(true, "fa");
    }

    @GetMapping("/forTest")
    @ApiOperation("测试")
    public static ResultEntity<Boolean> test1() {
        try {
            Document doc = Jsoup.connect("https://saishi.zgzcw.com/soccer").get();
            Elements elementsByClass = doc.getElementsByClass("rmls-nr");
            Elements allElements = elementsByClass.get(0).getAllElements();
            String url = null;
            for (int i = 2; i < allElements.size(); i++) {
                String s = allElements.get(i).toString().replace("\"", "");
                if (s.contains("欧冠")){
                    String s1 = s.substring(s.indexOf("http"));
                    int number = s1.indexOf(">");
                    url = s1.substring(0,number);
                    break;
                }
            }
            if (StringUtils.isNotEmpty(url)){
                Document doc1 = Jsoup.connect(url).get();

            }

        } catch (Exception e) {
            logger.error("出现了错误，{}", e.toString());
            e.printStackTrace();
        }
        return ResultTemplate.successData(true, "fa");
    }

    private static boolean isContains (String name){
        for (String s : match) {
            if (s.equals(name)){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        test1();
    }
}
