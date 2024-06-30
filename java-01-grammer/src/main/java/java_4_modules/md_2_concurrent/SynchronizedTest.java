package java_4_modules.md_2_concurrent;

import lombok.Data;
import org.junit.Test;

//一个计数器类，它将被多个线程访问和修改。需要确保在任何时候
// 只有一个线程能够修改计数器的值，以此来避免并发问题
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

//创建一个线程类，它将调用计数器的increment方法
class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}

//账户类
class BankAccount {
    private double balance;
    private final Object balanceLock = new Object();

    public BankAccount(double balance) {
        this.balance = balance;
    }

    //存款方法
    public void deposit(double amount) {
        synchronized (balanceLock) {
            System.out.println(Thread.currentThread().getName() + " is trying to deposit " + amount);
            double newBalance = balance + amount;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance = newBalance;

            System.out.println(Thread.currentThread().getName() + " completed deposit. New balance is " + balance);
        }
    }

    //获取账户余额
    public double getBalance() {
        synchronized (balanceLock) {
            return balance;
        }
    }
}


@Data
class DepositThread extends Thread {
    private BankAccount account;
    private double amount;

    public DepositThread(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.deposit(amount);
    }
}






public class SynchronizedTest {

    @Test
    public void test_01(){
        Counter counter = new Counter();

        //创建两个线程
        CounterThread thread1 = new CounterThread(counter);
        CounterThread thread2 = new CounterThread(counter);

        //启动线程
        thread1.start();
        thread2.start();

        //等待两个线程完成

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //打印最终计数值
        System.out.println("Final count is：" + counter.getCount());

    }


    @Test
    public void test_02(){
        BankAccount account = new BankAccount(100.0);

        //创建并启动两个存款线程
        DepositThread depositor1 = new DepositThread(account, 50.0);
        depositor1.setName("Depositor1");
        DepositThread depositor2 = new DepositThread(account, 75.0);
        depositor2.setName("depositor2");

        //启动线程
        depositor1.start();
        depositor2.start();

        //等待线程完成
        try {
            depositor1.join();
            depositor2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //打印最终账户余额
        System.out.println("Final balance is : " + account.getBalance());

    }
}
