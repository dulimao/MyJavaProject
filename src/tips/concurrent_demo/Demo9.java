package tips.concurrent_demo;

import java.util.concurrent.TimeUnit;

/**
*@author: 杜立茂
*@createDate  : 2019/3/24 15:49
*@description: 线程让步：等其他线程执行完成后，才开始执行当前线程
*/

public class Demo9 {

    public static void main(String[] args){
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            //每一个线程拥有前一个线程的引用，需要等待前一个线程终止，才能从等待队列里返回
            Thread thread = new Thread(new Runner(previous),String.valueOf(i));
            thread.start();
            previous = thread;
        }
    }

    static class Runner implements Runnable {

        private Thread thread;

        public Runner(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {

                thread.join();//原理就是利用wait/和notify机制实现
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}
