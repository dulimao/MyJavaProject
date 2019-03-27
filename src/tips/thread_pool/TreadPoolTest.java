package tips.thread_pool;

import java.util.concurrent.TimeUnit;

public class TreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        DefaultThreadPool<Task> threadPool = new DefaultThreadPool<>(1);
        for (int i = 0; i < 5; i++) {
            Task task = new Task();
            threadPool.execute(task);
        }

        TimeUnit.SECONDS.sleep(10);
        threadPool.execute(new Task());
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " isRunning");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " isTerminate");

        }
    }
}
