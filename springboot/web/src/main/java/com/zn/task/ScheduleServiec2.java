package com.zn.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduleServiec2 {

    @Scheduled(cron = "0/5 * * * * *")
    @Async
    public void test2(){

        log.info("第二个定时任务类  {}" +System.currentTimeMillis());
    }


}
