package com.yuanyuan.javademo.thread.producerandconsumer.v1;

import com.yuanyuan.javademo.thread.common.ShareResource;

/**
 * @author FAYUAN.PENG
 * @version \$Id: ProducerConsumerDemoError.java,  2021-01-16 21:13 FAYUAN.PENG Exp $$
 */
public class ProducerConsumerDemoV1 {

    public static void main(String[] args) {
        ShareResource resource = new ShareResource();
        for (int i = 0; i < 5; i++) {
            new Thread(new ProducerThreadV1(resource), "producer-thread" + i).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new ConsumerThreadV1(resource), "consumer-thread" + i).start();
        }
    }


}
