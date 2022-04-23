package com.bright.controller;

import com.bright.common.SysLog;
import com.bright.entity.*;
import com.bright.service.MatchService;
import com.bright.service.WarInfoService;
import com.bright.service.WarMatchService;
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
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
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
    @Autowired
    private MatchService matchService;

    @Autowired
    private WarMatchService warMatchService;

    @Autowired
    private WarInfoService warInfoService;

    private static String[] match = new String[]{
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
                if (validEnum) {
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
                    String dataId = substring1.substring(s1.indexOf("=") - 1, substring1.indexOf("data-homeid") - 1);
                    Document doc1 = Jsoup.connect("https://odds.500.com/fenxi/stat-" + dataId + ".shtml").get();
                    Elements odds_content = doc1.getElementsByClass("team-tb");
                    boolean door = odds_content.get(0).toString().contains("门");
                    if (door) {
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
                if (s.contains("欧冠")) {
                    String s1 = s.substring(s.indexOf("http"));
                    int number = s1.indexOf(">");
                    url = s1.substring(0, number);
                    Document doc1 = Jsoup.connect(url).get();

                    break;
                }
            }
            if (StringUtils.isNotEmpty(url)) {
                Document doc1 = Jsoup.connect(url).get();

            }

        } catch (Exception e) {
            logger.error("出现了错误，{}", e.toString());
            e.printStackTrace();
        }
        return ResultTemplate.successData(true, "fa");
    }

    @GetMapping("/getMatch")
    @ApiOperation("获取比赛数据")
    @SysLog(appId = "",reqDesc = "获取比赛信息存储到数据库", editType = EditEnum.INSERT)
    public ResultEntity<Boolean> getMatch() {
        try {
            String war = "欧冠";
            // 获取欧冠链接地址
            Document doc = Jsoup.connect("https://liansai.500.com/zuqiu-6268/").get();
            Elements elementsByClass = doc.getElementsByClass("lwrap");
            Element first = elementsByClass.first();
            Elements allElements = first.getAllElements();
            String s2 = allElements.get(9).toString().replaceAll("\"", "");
            int i1 = s2.indexOf("=/");
            int i2 = s2.indexOf("/>");
            String substring = s2.substring(i1 + 1, i2);
            String url1 = "https://liansai.500.com" + substring;
            // 获取赛程积分地址
            Document document = Jsoup.connect(url1).get();
            Elements full = document.getElementsByClass("lpage_race_head_l");
            String s3 = full.toString().replaceAll("\"", "");
            String s4 = s3.replaceAll("\n", "");
            int i3 = s4.indexOf("赛程积分榜");
            String substring1 = s3.substring(0, i3);
            String substring2 = substring1.substring(substring1.lastIndexOf("=/") + 1);
            String url2 = "https://liansai.500.com" + substring2;
            // 抓取真实使用数据
            Document document1 = Jsoup.connect(url2).get();
            Elements fulls = document1.getElementsByClass("lcontent_full");
            Elements schedules = fulls.get(0).getElementsByClass("ltab_btn");
            for (Element schedule : schedules) {
                String var1 = schedule.toString();
                String match = "分组赛";
                getChampion(war, var1, match);
            }
        } catch (Exception e) {
            logger.error("出现了错误，{}", e.toString());
            e.printStackTrace();
        }
        return ResultTemplate.successData(true, "插入数据库成功");
    }

    /**
     * 获取比赛信息
     *
     * @param war    欧冠
     * @param var1   内容
     * @param match2 小组赛、十六强、八强等
     * @throws IOException
     */
    private void getChampion(String war, String var1, String match2) throws IOException {
        if (var1.contains(match2)) {
            String path = var1.substring(var1.indexOf("/"), var1.indexOf("class") - 2);
            // 具体赛事信息地址
            Document doc1 = Jsoup.connect("https://liansai.500.com" + path).get();
            Elements elms = doc1.getElementsByClass("jTrInterval");
            for (Element elm : elms) {
                String var2 = elm.toString();
                String[] split = var2.split("</tr>");
                List<Match> matches = new ArrayList<Match>();
                for (int i = 0; i < split.length - 1; i++) {
                    // 获取比赛时间（北京时间）
                    Elements times = elm.getElementsByClass("td_time");
                    String var3 = times.get(i).toString();
                    String s = var3.replaceAll("\"", "");
                    String bjTime = s.substring(s.indexOf(">") + 1, s.indexOf("</td"));
                    // 获取比赛队伍left
                    Elements lefts = elm.getElementsByClass("td_lteam");
                    String var4 = lefts.get(i).toString();
                    String left = var4.replaceAll("\"", "");
                    String leftTeam = left.substring(left.indexOf(">") + 1, left.indexOf("</a"));
                    String lTeam = leftTeam.substring(leftTeam.lastIndexOf("=") + 1, leftTeam.lastIndexOf(">"));
                    // 获取比赛队伍right
                    Elements rights = elm.getElementsByClass("td_rteam");
                    String var5 = rights.get(i).toString();
                    String right = var5.replaceAll("\"", "");
                    String rightTeam = right.substring(right.indexOf(">") + 1, right.indexOf("</a"));
                    String rTeam = rightTeam.substring(rightTeam.lastIndexOf("=") + 1, rightTeam.lastIndexOf(">"));
                    // 比分score
                    String var6 = split[i].substring(split[i].indexOf("td_lteam"), split[i].indexOf("td_rteam"));
                    String span = var6.replaceAll("\"", "").substring(var6.indexOf("span"), var6.lastIndexOf("</td"));
                    String[] spans = span.split("span");
                    String lScore = spans[0].substring(spans[0].indexOf(">") + 1, spans[0].indexOf("<"));
                    String rScore = spans[2].substring(spans[2].indexOf(">") + 1, spans[2].indexOf("<"));
                    // 让球比分
                    String handicapScore = spans[3].substring(spans[3].indexOf(">") + 1, spans[3].indexOf("<"));
                    String score = lScore + ":" + rScore + handicapScore;
                    // todo  参赛队员 and 分析数据
                    Match match = new Match();
                    // 比赛名称 + 赛程
                    match.setWarName(war + match2);
                    match.setBjTime(bjTime);
                    match.setFinallyResults(score);
                    match.setNationOne(lTeam);
                    match.setNationTwo(rTeam);
                    matches.add(match);
                }
                boolean insert = false;
                if (!CollectionUtils.isEmpty(matches)) {
                    // 插入比赛表
                    insert = matchService.batchInsert(matches);
                }
                // 插入大赛表
                if (insert) {
                    WarInfo warInfo = warInfoService.getWarInfoByName(war);
                    List<WarMatch> warMatches = new ArrayList<WarMatch>();
                    for (Match specificMatch : matches) {
                        WarMatch warMatch = new WarMatch();
                        warMatch.setWarId(warInfo.getWarId());
                        warMatch.setMatchId(specificMatch.getMatchId());
                        warMatch.setIsDel(0);
                        warMatches.add(warMatch);
                    }
                    warMatchService.batchInsert(warMatches);
                }
            }
        }
    }

    private static boolean isContains(String name) {
        for (String s : match) {
            if (s.equals(name)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
//        getMatch();
    }
}
