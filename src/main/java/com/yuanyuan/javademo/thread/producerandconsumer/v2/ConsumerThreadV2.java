package com.yuanyuan.javademo.thread.producerandconsumer.v2;

import com.yuanyuan.javademo.thread.common.ShareResource;

public class ConsumerThreadV2 implements Runnable {

    private ShareResource resource;

    public ConsumerThreadV2(ShareResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        synchronized (resource) {
            resource.lock.lock();
            try {
                while (resource.list.size() == 0) {
                    try {
                        resource.condition.await();
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
                resource.condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                resource.lock.unlock();
            }

        }
    }
}