package com.yuanyuan.javademo.thread.producerandconsumer.v1;

import cn.hutool.core.lang.UUID;
import com.yuanyuan.javademo.thread.common.ShareResource;

/**
 * 生产线程
 */
public class ProducerThreadV1 implements Runnable {

    private ShareResource resource;

    public ProducerThreadV1(ShareResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        synchronized (resource) {
            while (resource.list.size() == ShareResource.RESOURCE_MAX_LIMIT) {
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
            String uuid = UUID.fastUUID().toString();
            resource.list.add(uuid);
            System.out.println(Thread.currentThread().getName() + "生产了" + uuid);
            resource.notifyAll();
        }
    }
}