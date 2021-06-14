package com.yuanyuan.javademo.juc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author FAYUAN.PENG
 * @version \$Id: CountDownLatchDemo.java,  2021-01-15 8:21 FAYUAN.PENG Exp $$
 */
public class CountDownLatchDemo {

    public static final int STUDENT_NUM = 10;
    private static CountDownLatch countDownLatch = new CountDownLatch(STUDENT_NUM);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new StudentThread(i + "", countDownLatch)).start();
        }

        new Thread(new TeacherThread(countDownLatch)).start();
    }

    public static class StudentThread implements Runnable {

        private String studentName;
        private CountDownLatch countDownLatch;

        public StudentThread(String studentName, CountDownLatch countDownLatch) {
            this.studentName = studentName;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("学生" + studentName + "已交卷");
            // 执行countDown方法，计数器就会减一
            countDownLatch.countDown();
        }
    }

    public static class TeacherThread implements Runnable {

        private CountDownLatch countDownLatch;

        public TeacherThread(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                // 当计数器为0时，方法返回，否则会一致阻塞
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("所有学生都已交卷，老师离开");
        }
    }
}
