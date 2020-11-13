package com.chao.note.threadFolder;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Chao on 2020/7/22.
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        System.out.println(timeTasks(2, task));
    }

    public static long timeTasks(int nThreads, final Runnable task)
            throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        // TODO: handle exception
                    }
                }
            };
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}

    class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());

        }
    }
