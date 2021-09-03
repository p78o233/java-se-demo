package thread.sync;
/*
 * @author p78o2
 * @date 2021/9/2
 */

public class SyncBlock {
    public void doLongTimeTask(){
        try {
            System.out.println("当前线程开始"+Thread.currentThread().getName()+",正在执行一个长时间的业务，内容不要同步");
            Thread.sleep(2000);
            synchronized (this){
                System.out.println("当前线程"+Thread.currentThread().getName()+",正在执行一个长时间的业务，同步");
                Thread.sleep(1000);
            }
            System.out.println("当前线程开始"+Thread.currentThread().getName()+",正在执行一个长时间的业务，执行完毕");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        final SyncBlock block = new SyncBlock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                block.doLongTimeTask();
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                block.doLongTimeTask();
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
