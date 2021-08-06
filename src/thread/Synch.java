package thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @author p78o2
 * @date 2021/6/22
 */
//synchronized 关键字
public class Synch {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("线程A ");    // 实例化对象
        MyThread mt2 = new MyThread("线程B ");    // 实例化对象
        Thread t1 = new Thread(mt1);       // 实例化Thread类对象
        Thread t2 = new Thread(mt2);       // 实例化Thread类对象
        t1.start();    // 启动多线程
        t2.start();    // 启动多线程
    }
}

class MyThread implements Runnable {
    private String name;

    //需要同步的变量加上volatile
    private AtomicInteger account = new AtomicInteger();

    //    lock变量
    private int lockAccount = 0;
    private Lock lock = new ReentrantLock();

    public MyThread(String name) {
        this.name = name;
    }

    //    同步方法
    public synchronized void test1() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "运行，i = " + i);
        }
        System.out.println(this.name + "test1====================================");
    }

    //    锁定临界对象
//    锁定当前对象这种同步块与上面同步方法其实是一致的
    public void test2() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(name + "运行，i = " + i);
            }
            System.out.println(this.name + "test2********************************");
        }
    }

    //    选择使用对象做锁
    public void test3() {
        String s = "1";
//        s 这个对象没有释放之前其他线程无法使用下面的同步代码块
        synchronized (s) {
            for (int i = 0; i < 10; i++) {
                System.out.println(name + "运行，i = " + i);
            }
            System.out.println(this.name + "test3********************************");
        }
    }

    //    AtomicInteger原子关键字,共享变量，多个线程有一个独立的变量，因为变量不放入主内存中只放在cpu的高速缓存里面
    public void test4() {
        for (int i = 0; i < 10; i++) {
            account.set(account.get()-1);
            System.out.println(name + "运行，account = " + String.valueOf(account.get()));
        }
    }


    @Override
    public void run() {
//        同步方法
//        test1();
//        锁定当前对象
//        test2();
//        锁定临时对象
//        test3();
//        volatile关键字
        account.set(100);
        test4();
    }
}
