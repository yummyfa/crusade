package com.bright.controller;

import com.bright.service.CompanyService;
import com.bright.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangliang
 * @Date: 2022/2/25 9:31
 */
@RestController
public class TestController {
    @Autowired
    private TestService testService;


    private int number1 = 1;

    private int number2 = 2;

    @PostMapping("/test1")
    public void test1(){
        testService.test1();
    }

    @PostMapping("/test2")
    public Integer test2(){
        return number1;
    }

    private static Object valueFirst = new Object();//第一个锁
    private static Object valueSecond = new Object();//第二个锁

    //先拿第一个锁，再拿第二个锁
    private static void fisrtToSecond() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        synchronized (valueFirst){
            System.out.println(threadName+" get 1st");
            Thread.sleep(100);
            synchronized (valueSecond){
                System.out.println(threadName+" get 2nd");
            }
        }
    }

    //先拿第二个锁，再拿第一个锁
    private static void SecondToFisrt() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        synchronized (valueSecond){
            System.out.println(threadName+" get 2nd");
            Thread.sleep(100);
            synchronized (valueFirst){
                System.out.println(threadName+" get 1st");
            }
        }
    }

}
