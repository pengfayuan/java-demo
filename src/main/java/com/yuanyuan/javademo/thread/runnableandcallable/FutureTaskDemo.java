package com.yuanyuan.javademo.thread.runnableandcallable;

import cn.hutool.core.collection.CollUtil;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author FAYUAN.PENG
 * @version \$Id: FutureTaskDemo.java,  2021-01-19 11:47 FAYUAN.PENG Exp $$
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = CollUtil.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        FutureTask<Integer> futureTask = new FutureTask<>(new CalcThread(list));
        futureTask.run();
        Integer result = futureTask.get();
        System.out.println(result);
    }

    public static class CalcThread implements Callable<Integer> {

        private List<Integer> list;

        public CalcThread(List<Integer> list) {
            this.list = list;
        }

        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return list.stream().mapToInt(Integer::intValue).sum();
        }
    }
}
