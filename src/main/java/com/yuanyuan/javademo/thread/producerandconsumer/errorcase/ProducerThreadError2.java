package com.yuanyuan.javademo.thread.producerandconsumer.errorcase;

import cn.hutool.core.lang.UUID;
import com.yuanyuan.javademo.thread.common.ShareResource;

/**
 * 生产线程
 */
public class ProducerThreadError2 implements Runnable {

    private ShareResource resource;

    public ProducerThreadError2(ShareResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        synchronized (resource) {
            // 这里一定是while，被唤醒后需要再次判断
            if (resource.list.size() == ShareResource.RESOURCE_MAX_LIMIT) {
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