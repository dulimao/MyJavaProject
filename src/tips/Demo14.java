package tips;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo14 {

    private static Lock fairLock = new ReentrantLock(true);

    public static void main(String[] args){
        testLock(fairLock);
    }

    private static void testLock(Lock lock) {
        for (int i = 0; i < 5; i++) {
            Job job = new Job(lock);
            job.start();
        }
    }


    private static class Job extends  Thread{
        private Lock lock;
        public Job(Lock lock){
            this.lock = lock;
        }

        @Override
        public void run() {
            super.run();
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName());
            }finally {
                lock.unlock();
            }
        }
    }

}
