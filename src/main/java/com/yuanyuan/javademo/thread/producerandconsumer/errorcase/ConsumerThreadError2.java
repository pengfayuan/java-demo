package com.yuanyuan.javademo.thread.producerandconsumer.errorcase;

import com.yuanyuan.javademo.thread.common.ShareResource;

public class ConsumerThreadError2 implements Runnable {

    private ShareResource resource;

    public ConsumerThreadError2(ShareResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        synchronized (resource) {
            // 这里一定是while，被唤醒后需要再次判断
            if (resource.list.size() == 0) {
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