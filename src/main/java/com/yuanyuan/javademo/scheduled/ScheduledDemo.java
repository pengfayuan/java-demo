package com.yuanyuan.javademo.scheduled;

import cn.hutool.core.thread.ThreadUtil;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author FAYUAN.PENG
 * @version \$Id: ScheduledDemo.java,  2021-03-11 8:44 FAYUAN.PENG Exp $$
 */
@Component
@Slf4j
public class ScheduledDemo {

    @Scheduled(cron = "0/3 * * * * ?")
    public void test() {
        log.info("start");
        ThreadUtil.sleep(1, TimeUnit.SECONDS);
        log.info("end");
    }
}
