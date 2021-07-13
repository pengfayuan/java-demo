package com.yuanyuan.javademo.thread.producerandconsumer.v2;

import cn.hutool.core.lang.UUID;
import com.yuanyuan.javademo.thread.common.ShareResource;

/**
 * 生产线程
 */
public class ProducerThreadV2 implements Runnable {

    private ShareResource resource;

    public ProducerThreadV2(ShareResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.lock.lock();
        try {
            while (resource.list.size() == ShareResource.RESOURCE_MAX_LIMIT) {
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
            String uuid = UUID.fastUUID().toString();
            resource.list.add(uuid);
            System.out.println(Thread.currentThread().getName() + "生产了" + uuid);
            resource.condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resource.lock.unlock();
        }
    }
}