package com.chao.note.threadFolder;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * Created by 15313 on 2019/11/18.
 */
public class ThreadLocalExample implements Runnable{

    // SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<Integer> formatter = ThreadLocal.withInitial(() -> new Integer(100));
    private static final ThreadLocal<String> form = ThreadLocal.withInitial(() -> new String("name"));

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        for (int i=0;i<10;i++){
            Thread thread = new Thread(threadLocalExample,""+i);
            thread.sleep(new Random().nextInt(1000));
            thread.start();
        }
        System.out.println("main = " + formatter.get());
    }

    @Override
    public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+formatter.get().toString());
        try {
            Thread.sleep(new Random().nextInt(1000));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(formatter.get()-1);
        form.set("name " + Thread.currentThread().getName());
        fun();
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toString());
    }


    public void fun(){
        System.out.println("fun "+Thread.currentThread().getName()+" formatter = "+formatter.get().toString());
        System.out.println("fun "+Thread.currentThread().getName()+" name = "+form.get().toString());
    }
}
