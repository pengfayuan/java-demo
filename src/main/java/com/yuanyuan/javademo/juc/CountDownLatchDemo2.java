package com.yuanyuan.javademo.juc;

import cn.hutool.core.collection.CollUtil;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author FAYUAN.PENG
 * @version \$Id: CountDownLatchDemo.java,  2021-01-15 8:21 FAYUAN.PENG Exp $$
 */
public class CountDownLatchDemo2 {

    public static final int STUDENT_NUM = 10;
    private static CountDownLatch countDownLatch = new CountDownLatch(STUDENT_NUM);

    public static void main(String[] args) {
        System.out.println("start");
        List<Integer> list = CollUtil.newArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        list.parallelStream().forEach(i -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        });

        System.out.println("end");
    }
}
