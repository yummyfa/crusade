package com.bright.controller;

import com.bright.entity.ResultEntity;
import com.bright.entity.ResultTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Set;

/**
 * @Author: wangliang
 * @Date: 2021/11/13 18:05
 */
@Api(tags = "获取信息")
@RestController
@RequestMapping("/capture")
public class CaptureController {

    @GetMapping("/getRealTime")
    @ApiOperation("获取实时信息")
    public ResultEntity<Boolean> getData(){
        try {
            Document doc = Jsoup.connect("https://www.runoob.com/scala/scala-install.html").get();
            Elements elementsByClass = doc.getElementsByClass("article-intro");
            // 获取字
            Elements h1 = elementsByClass.get(0).getElementsByTag("h1");
            Set<String> strings = doc.classNames();
            Elements elementsByAttribute = doc.select("div").get(72).getAllElements().get(1).getElementsByAttribute("src");

            doc.select("sidebar-box gallery-list").attr("_blank", "jsoup");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultTemplate.successData(true,"fa");
    }

}
