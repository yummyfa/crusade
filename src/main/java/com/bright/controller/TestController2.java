package com.bright.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bright.util.HttpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wangliang
 * @date 2022/4/17 15:59
 */
@RestController
@RequestMapping("/testList")
public class TestController2 {

    @GetMapping("/test")
    public void test2(){
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 1001; i++) {
            String s = "hi";
            list.add(s);
            System.out.println(s);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list",list);
//        String url = "127.0.0.1:8068/list/getList";
//        HttpUtil.sendPostJson(url,jsonObject,new HashMap<String, String>());
    }
}

