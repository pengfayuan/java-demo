package com.yuanyuan.javademo.juc.blockingqueue;

import cn.hutool.core.thread.ThreadUtil;
import java.util.concurrent.SynchronousQueue;

/**
 * @author FAYUAN.PENG
 * @version \$Id: SynchronousQueueDemo.java,  2021-01-17 12:38 FAYUAN.PENG Exp $$
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        new Thread(new TakeThread(synchronousQueue)).start();
        new Thread(new PutThread(synchronousQueue)).start();

    }

    public static class TakeThread implements Runnable {

        private SynchronousQueue<String> synchronousQueue;

        public TakeThread(SynchronousQueue<String> synchronousQueue) {
            this.synchronousQueue = synchronousQueue;
        }

        @Override
        public void run() {
            try {
                ThreadUtil.sleep(100);
                System.out.println("获取到元素：" + synchronousQueue.take());
                ThreadUtil.sleep(100);
                System.out.println("获取到元素：" + synchronousQueue.take());
                ThreadUtil.sleep(1000);
                System.out.println("获取到元素：" + synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class PutThread implements Runnable {

        private SynchronousQueue<String> synchronousQueue;

        public PutThread(SynchronousQueue<String> synchronousQueue) {
            this.synchronousQueue = synchronousQueue;
        }

        @Override
        public void run() {
            try {
                synchronousQueue.put("AAA");
                System.out.println("添加元素AAA");
                ThreadUtil.sleep(100);
                synchronousQueue.put("BBB");
                System.out.println("添加元素BBB");
                ThreadUtil.sleep(100);
                synchronousQueue.put("CCC");
                System.out.println("添加元素CCC");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
