package com.bright.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangliang
 * @date 2022/4/17 15:46
 */
@RestController
@RequestMapping("/list")
public class ArrayListController {

    @PostMapping("/getList")
    public void getList(@RequestBody List<String> list){
        System.out.println(list);
    }
}
