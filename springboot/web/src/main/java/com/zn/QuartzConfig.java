package com.zn;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * quart实现定时任务
 */
@Configuration
public class QuartzConfig {

    /*
    public class QuartzConfig {

        @Bean
        public JobDetail teatQuartzDetail(){
             //TestQuartz 一个继承quart的实现类
            return JobBuilder.newJob(TestQuartz.class).withIdentity("testQuartz").storeDurably().build();

        }

        @Bean
        public Trigger testQuartzTrigger(){

            SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(10)  //设置时间周期单位秒
                    .repeatForever();
            return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())

                    .withIdentity("testQuartz")
                    .withSchedule(scheduleBuilder)
                    .build();

        }

    }*/
}
