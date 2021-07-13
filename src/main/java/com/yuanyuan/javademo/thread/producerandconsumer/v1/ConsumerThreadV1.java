package com.yuanyuan.javademo.thread.producerandconsumer.v1;

import com.yuanyuan.javademo.thread.common.ShareResource;

public class ConsumerThreadV1 implements Runnable {

    private ShareResource resource;

    public ConsumerThreadV1(ShareResource resource) {
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
            resource.notifyAll();
        }
    }
}