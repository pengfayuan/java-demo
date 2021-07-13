package com.yuanyuan.javademo.thread.producerandconsumer.errorcase;

import com.yuanyuan.javademo.thread.common.ShareResource;

/**
 * @author FAYUAN.PENG
 * @version \$Id: ProducerConsumerDemoError.java,  2021-01-16 21:13 FAYUAN.PENG Exp $$
 */
public class ProducerConsumerDemoError {

    public static void main(String[] args) {
        ShareResource resource = new ShareResource();
        for (int i = 0; i < 5; i++) {
            new Thread(new ProducerThreadError(resource), "producer-thread" + i).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new ConsumerThreadError(resource), "consumer-thread" + i).start();
        }
    }


}
