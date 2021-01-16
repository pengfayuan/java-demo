package com.yuanyuan.javademo.juc;

import cn.hutool.core.thread.ThreadUtil;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author FAYUAN.PENG
 * @version \$Id: SemaphoreDemo.java,  2021-01-16 16:18 FAYUAN.PENG Exp $$
 */
public class SemaphoreDemo {

    // 默认初始化10个通行证，即同时只有10辆车可以通过桥
    public static final int SEMAPHORE_LIMIT = 10;
    public static final Semaphore SEMAPHORE = new Semaphore(SEMAPHORE_LIMIT);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Car(i + "", SEMAPHORE)).start();
        }
    }

    public static class Car implements Runnable {

        private String name;
        private Semaphore semaphore;

        public Car(String name, Semaphore semaphore) {
            this.name = name;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                Random random = new Random();
                semaphore.acquire();
                System.out.println(LocalDateTime.now() + "  " + name + "拿到了通行证");
                ThreadUtil.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(LocalDateTime.now() + "  " + name + "归还了通行证");
                semaphore.release();
            }
        }
    }
}
