package tips.concurrent_demo;

import java.util.concurrent.TimeUnit;

/**
*@author: 杜立茂
*@createDate  : 2019/3/24 12:09
*@description: 通过两种方式正确停止线程
*/

public class Demo6 {


    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread countThread1 = new Thread(one,"CountThread1");
        countThread1.start();
        TimeUnit.SECONDS.sleep(1);
        countThread1.interrupt();

        Runner two = new Runner();
        Thread countThread2 = new Thread(two,"countThread2");
        countThread2.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    private static class Runner implements Runnable {
        private long i = 0;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println(Thread.currentThread().getName() + "count i = " + i);
        }

        public void cancel() {
            on = false;
        }
    }

}
