package com.zn.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * 1.直接使用Task注解最方便
 * fixedRate:定义一个按一定频率执行的定时任务
 * fixedDelay:定义一个按一定频率执行的定时任务，并且可以配合initialDelay定义第一次执行延迟执行时间
 * cron：配置任务执行时间
 * 2.使用quartz +配置类实现定时任务 extends QuartzJobBean
 * 创建配置类@Configration @EnableAsync类注解 @bean，用任务线程池执行，这样定时任务都是不同线程去执行，在定时任务类或者方法上加@Async
 */
@Slf4j
@Component
public class ScheduleService {

    @Scheduled(cron = "0/5 * * * * *")
    @Async
    public void testSchedulezero(){

        log.info("使用cron开启定时任务  {}"+System.currentTimeMillis());
        //业务操作
    }

    @Scheduled(fixedRate = 5000)
    @Async
    public void testScheduleone(){

        log.info("使用fixedRate开启定时任务  {}"+System.currentTimeMillis());
        //业务操作
    }


    @Scheduled(fixedDelay = 5000,initialDelay=3000)
    @Async
    public void testScheduletwo(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("使用fixedDelay开启定时任务  {}"+simpleDateFormat.format(System.currentTimeMillis()));
        //业务操作
    }
}
