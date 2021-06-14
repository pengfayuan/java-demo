package com.yuanyuan.javademo.juc;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author FAYUAN.PENG
 * @version \$Id: CyclicBarrierDemo.java,  2021-01-15 8:56 FAYUAN.PENG Exp $$
 */
public class CyclicBarrierDemo {

    public static final int STUDENT_NUM = 10;
    public static final CyclicBarrier cyclicBarrier = new CyclicBarrier(STUDENT_NUM,
            new CallBackThread());

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new RunningMainThread(i + "", cyclicBarrier)).start();
        }
    }

    public static class RunningMainThread implements Runnable {

        private String name;
        private CyclicBarrier cyclicBarrier;

        public RunningMainThread(String name, CyclicBarrier cyclicBarrier) {
            this.name = name;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(3000));

                System.out.println("运动员" + name + "已到，等待其余运动员");
                // 当计数器等于初始设置到值时，方法返回，否则会一直阻塞
                cyclicBarrier.await();
                Thread.sleep(random.nextInt(3000));
                System.out.println("运动员" + name + "出发");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static class CallBackThread implements Runnable {

        @Override
        public void run() {
            System.out.println("所有运动员已就位");
        }
    }
}
