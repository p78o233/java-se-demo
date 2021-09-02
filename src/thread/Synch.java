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

