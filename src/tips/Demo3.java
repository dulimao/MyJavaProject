package tips;

import java.util.concurrent.TimeUnit;
/**
*@author: 杜立茂
*@createDate  : 2019/3/24 10:04
*@description: jps:查看当前线程及对应的进程ID
 *             jstack id:查看当前进程中个个线程的执行状态
*/

public class Demo3 {

    public static void main(String[] args) {
//        new Thread(new TimeWaiting(),"TimeWaitingThread").start();
        new Thread(new Waiting(),"WaitingThread").start();
//        //使用两个Blocked线程，一个获取锁，另一个被阻塞
//        new Thread(new Blocked(),"BlockedThread-1").start();
//        new Thread(new Blocked(),"BlockedThread-2").start();
    }

    //该线程不断地进行睡眠
    static class TimeWaiting implements Runnable{
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(1);
                System.out.println("TimeWaitingThread");
            }
        }
    }

    //该线程在Waiting.class示例上等待
    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true){
                System.out.println("Waiting Thread");
                synchronized (Waiting.class) {
                    try {
                        System.out.println("Waiting");
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    //该线程在Blocked.class示例上加锁后，不会释放锁
    static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized (Blocked.class) {
                while(true){
                    SleepUtils.second(1);
                    System.out.println("Thread: " + Thread.currentThread().getName());
                }
            }
        }
    }



}





class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
