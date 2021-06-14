package com.yuanyuan.javademo.thread.producerandconsumer.errorcase;

import com.yuanyuan.javademo.thread.common.ShareResource;

public class ConsumerThreadError implements Runnable {

    private ShareResource resource;

    public ConsumerThreadError(ShareResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        synchronized (resource) {
            while (resource.list.size() == 0) {
                try {
                    resource.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String uuid = resource.list.remove(0);
            System.out.println(Thread.currentThread().getName() + "消费了" + uuid);
            // 多线程环境，这里必须notifyAll唤醒所有等待的线程，否则，可能会产生死锁
            resource.notify();
        }
    }
}