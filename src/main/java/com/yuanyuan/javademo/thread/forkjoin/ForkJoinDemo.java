package com.yuanyuan.javademo.thread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author FAYUAN.PENG
 * @version \$Id: ForkJoinDemo.java,  2021-01-19 21:53 FAYUAN.PENG Exp $$
 */
public class ForkJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CountTask task = new CountTask(1, 100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> result = forkJoinPool.submit(task);
        System.out.println(result.get());
    }

}

class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            leftTask.fork();
            rightTask.fork();
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            return leftResult + rightResult;
        }
    }
}