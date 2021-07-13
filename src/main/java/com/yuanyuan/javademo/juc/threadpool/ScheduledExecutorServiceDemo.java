package com.yuanyuan.javademo.juc.threadpool;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author FAYUAN.PENG
 * @version \$Id: ScheduledExecutorServiceDemo.java,  2021-02-21 17:13 FAYUAN.PENG Exp $$
 */
public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(10);
        service.scheduleAtFixedRate(() -> test(), 3, 5, TimeUnit.SECONDS);
    }

    private static void test() {
        System.out.println("test " + LocalDateTime.now());
    }
}
