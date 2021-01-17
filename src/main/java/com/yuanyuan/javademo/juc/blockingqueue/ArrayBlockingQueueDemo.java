package com.yuanyuan.javademo.juc.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author FAYUAN.PENG
 * @version \$Id: ArrayBlockingQueueDemo.java,  2021-01-16 23:08 FAYUAN.PENG Exp $$
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue<>(2);

//        testAddAndRemove(blockingQueue);
//        testOfferAndPoll(blockingQueue);
//        testPutAndTake(blockingQueue);
        testTimeOut(blockingQueue);

    }

    /**
     * add；当队列满时，方法会抛出异常【java.lang.IllegalStateException: Queue full】
     * remove：当队列为空时，方法会抛出异常【java.util.NoSuchElementException】
     */
    private static void testAddAndRemove(BlockingQueue blockingQueue) {
        blockingQueue.add("AAA");
        blockingQueue.add("BBB");
//        blockingQueue.add("CCC");

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
    }

    /**
     * offer：添加成功，方法返回true，当队列满时，返回false
     * poll：获取到元素，返回元素，当队列为空时，返回null
     */
    public static void testOfferAndPoll(BlockingQueue blockingQueue) {
        System.out.println(blockingQueue.offer("AAA"));
        System.out.println(blockingQueue.offer("BBB"));
        System.out.println(blockingQueue.offer("CCC"));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }

    /**
     * put：当队列未满时，元素添加成功，方法返回，当队列满时，方法阻塞
     * take：当队列不为空时，返回获取的元素，当队列为空时，方法阻塞
     * @param blockingQueue
     * @throws InterruptedException
     */
    public static void testPutAndTake(BlockingQueue blockingQueue) throws InterruptedException {
        blockingQueue.put("AAA");
        blockingQueue.put("BBB");
//        blockingQueue.put("CCC");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
    }

    /**
     *
     * @param blockingQueue
     * @throws InterruptedException
     */
    public static void testTimeOut(BlockingQueue blockingQueue) throws InterruptedException {
        System.out.println(blockingQueue.offer("AAA", 2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("BBB", 2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("CCC", 2, TimeUnit.SECONDS));

        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));

    }
}
