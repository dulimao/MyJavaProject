package thread;

import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: 杜立茂
 * @CreateDate : 2018/12/21 10:47
 * @Description: 线程池：Execute封装好的线程框架
 *                      自己声明一个线程池： corePoolSize:核心线程数，Google推荐数量为CPU核数 + 1
 *                                          maximumPoolSize：最大线程数
 *                                          keepAliveTime：线程池中，除去核心线程，其他线程的存活时间
 *                                          TimeUnit：存活时间的单位
 *                                          BlockingQueue<Runnable>：工作线程的等待队列（单端队列）
 *                                          BlockingQueue：单端队列
 *                                          BlockingDeque：双端队列
 *                                          ThreadFactory：创建线程的线程工厂
 *                        submit()和execute()区别：
 *
 */

/**
 * 需求：多线程时，只能有5个线程同时工作，方式一：使用线程池，方式二：使用信号量控制
 */
class TRunnable implements Runnable {
    @Override
    public void run() {
        try {
//            Semaphore semaphore = new Semaphore(5);//允许的线程熟练
//            semaphore.acquire();
            System.out.println("线程" + Thread.currentThread() + "  进入线程池");
            Thread.sleep(500);
            System.out.println("线程" + Thread.currentThread() + "  出了线程池");
//            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

public class ThreadPool {

    public static void main(String[] args) {

//        for (int i = 0; i < 100; i++) {
//            new Thread(new TRunnable()).start();
//        }

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100), new ThreadFactory() {

            AtomicInteger i = new AtomicInteger();//注意：不能用int i,因为integer i++ 是线程不安全的

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);

                thread.setName("Thread - " + i.getAndIncrement());
                return thread;
            }
        }){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                super.beforeExecute(t, r);
                System.out.println("线程执行之前");
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                System.out.println("线程执行之后");
            }
        };

        threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("当前任务被拒绝");
            }

        });

//        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(new TRunnable());
//        }

//        threadPoolExecutor.submit(new TCallable());//有返回值
    }


}
