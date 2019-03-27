package tips;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Demo13 {
    static final Lock lock = new TwinsLock();

    public static void main(String[] args) {
        //启动10个线程
        for (int i = 0; i < 10; i++){
            Work work = new Work();
            work.setDaemon(true);
            work.start();
        }

        //每隔一秒换行
        for (int i = 0; i < 10; i++){
            SleepUtils.second(1);
            System.out.println();
        }

    }



    static class Work extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    SleepUtils.second(1);
                    System.out.println(Thread.currentThread().getName());
                    SleepUtils.second(1);
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}
