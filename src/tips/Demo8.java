package tips;

import java.util.concurrent.TimeUnit;


/**
*@author: 杜立茂
*@createDate  : 2019/3/24 15:33
*@description: 等待/通知机制经典范式
*/


public class Demo8 {

    private static boolean flag = true;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new WaitRunnable()).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new NotifyRunnable()).start();
    }


    static class WaitRunnable implements Runnable{
        @Override
        public void run() {
            //加锁，拥有lock的Monitor
            synchronized (lock){
                while (flag){
                    //条件不满足，进入等待状态
                    System.out.println("WaitRunnable is Waiting");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //条件满足开始完成工作
                System.out.println("WaitRunnable is notify");

            }
        }
    }

    static class NotifyRunnable implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                System.out.println("NotifyRunnable is hold lock");
                lock.notifyAll();
                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //再次加锁
            synchronized (lock) {
                System.out.println("NotifyRunnable is hold lock again");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
