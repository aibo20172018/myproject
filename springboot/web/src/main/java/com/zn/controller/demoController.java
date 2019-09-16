package com.zn.controller;
import com.zn.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

@RestController
@RequestMapping("demo")
public class demoController {

    @Autowired
    private TestService testService;

    private static final ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @GetMapping("test")
    public String test() {
        System.out.println("开始执行");
        String result = testService.test();
        return result;
    }

    @RequestMapping("notsleep")
    @ResponseBody
    public  ModelAndView  notsleep(ModelAndView modelAndView){
        System.out.println("'kaishi");
        modelAndView.setViewName("index");
        modelAndView.addObject("key",testService.test()+"2019-08-26");
        String mobile= "134585185654";
        boolean matchresult = Pattern.matches("^[1][3,4,5,6,7,8,9][0-9]{9}$", mobile);
        //modelAndView.addObject();
        executorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });



        return modelAndView;
    }
}