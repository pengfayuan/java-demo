package com.yuanyuan.javademo.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author FAYUAN.PENG
 * @version \$Id: ConditionDemo.java,  2021-01-17 21:34 FAYUAN.PENG Exp $$
 */
public class ConditionDemo {

    private static volatile String THREAD_FLAG = "A";
    private static Lock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();

    /**
     * 启动3个线程A、B、C A输出AAA B输出BBB C输出CCC …… 循环输出5遍
     */
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                lock.lock();
                try {
                    while (!"A".equals(THREAD_FLAG)) {
                        conditionA.await();
                    }
                    System.out.println("AAA");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    THREAD_FLAG = "B";
                    conditionB.signal();
                    lock.unlock();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                lock.lock();
                try {
                    while (!"B".equals(THREAD_FLAG)) {
                        conditionB.await();
                    }
                    System.out.println("BBB");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    THREAD_FLAG = "C";
                    conditionC.signal();
                    lock.unlock();
                }
            }

        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                lock.lock();
                try {
                    while (!"C".equals(THREAD_FLAG)) {
                        conditionC.await();
                    }
                    System.out.println("CCC");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    THREAD_FLAG = "A";
                    conditionA.signal();
                    lock.unlock();
                }
            }

        }, "C").start();
    }
}
