package com.yuanyuan.javademo;

import cn.hutool.core.thread.ThreadUtil;
import java.util.concurrent.TimeUnit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaDemoApplication.class, args);
        ThreadUtil.sleep(100, TimeUnit.MINUTES);
    }
}
