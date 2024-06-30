package java_4_modules.md_2_concurrent;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadLifecycle {

    //线程创建的多种方式
    //1. //继承Thread类，重写run方法
    @Test
    public void test_01() {
        class MyThread extends Thread {
            @Override
            public void run() {
                System.out.println("Thread executed by extending Thread class.");
            }
        }

        MyThread myThread = new MyThread();
        myThread.start();
    }

    //实现Runnable接口，传递给Thread
    @Test
    public void test_02() {
        class MyRunnable implements Runnable {
            @Override
            public void run() {
                System.out.println("Thread executed by implementing Runnable interface.");
            }
        }

        //传递
        MyRunnable myRunnable = new MyRunnable();
        Thread myThread = new Thread(myRunnable);
        myThread.start();

        //或者使用匿名类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread executed with anonymous class.");
            }
        };
        new Thread(runnable).start();

        //lambda也可以
        new Thread(()->System.out.println("Thread executed with lambda expression.")).start();
    }

    //使用Executor框架
    @Test
    public void test_03(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->System.out.println("Thread executed with Executor framework."));
        executorService.shutdown();
    }

    //用Callable和Future,可以有返回值
    @Test
    public void test_04(){
       //创建一个ExecutorService管理线程
        ExecutorService executor = Executors.newFixedThreadPool(1);

        //创建Callable对象
        Callable<String> callableTask = () -> {
            //task
          return "Result of the callable";
        };

        //提交Callable对象到ExecutorService，获取Future对象
        Future<String> future = executor.submit(callableTask);

        try {
            String result = future.get();
            System.out.println("Callable returned: " + result);
        } catch (InterruptedException |ExecutionException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();
    }

    @Test
    public void test_05() throws InterruptedException {

        //创建线程
        Thread thread = new Thread(
                () -> {
                    try {
                        Thread.sleep(2000);
                        synchronized (ThreadLifecycle.class) {
                            ThreadLifecycle.class.wait();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
        );

        //启动线程
        thread.start();
        System.out.println("Thread state after calling start(): " + thread.getState());

        //线程进入等待状态
        synchronized (ThreadLifecycle.class) {
            ThreadLifecycle.class.notify();
        }

        // 等待线程完成运行,此时线程处理终止状态
        thread.join();

        System.out.println("Thread state after completion: " + thread.getState());

    }
}
