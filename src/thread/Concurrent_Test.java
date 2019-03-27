package thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.*;

public class Concurrent_Test {

    public static void main(String[] args) throws InterruptedException {
        Hashtable<String,String> map = new Hashtable<>();
        map.put("name","dlm");
        Map<String, String> stringStringMap = Collections.synchronizedMap(map);


        //并发包，分段加锁（最多分16段），每一段相当于一个hashtable,所以相对每一段来说，
        // 这段内容是线程安全的
        ConcurrentHashMap<String,String> map1 = new ConcurrentHashMap<>();
        map1.put("name","dlm");

        /*
        //计数器 CountDownLatch
        System.out.println("线程开启");

         CountDownLatch latch = new CountDownLatch(2);
        MyThread t1 = new MyThread(latch);
        MyThread t2 = new MyThread(latch);

        t1.start();
        t2.start();

        Thread.sleep(1000);

        latch.await();


        System.out.println("主线程执行结束");
        */

        /*
        //CyclicBarrier 循环临界区
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        MyThread1 t1 = new MyThread1(cyclicBarrier);
        MyThread1 t2 = new MyThread1(cyclicBarrier);

        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println("主线程执行结束");
        */

//        ConcurrentLinkedQueue
        //并发队列 ConcurrentLinkedQueue:无界线程安全
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        //ConcurrentLinkedDeque
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

        //阻塞队列：BlockingQueue，一般用于生产者/消费者模型，
        // 支持两个附加操作：
        //1、队列里是空的时候，获取元素的线程会阻塞等待队列变为非空状态
        //2、队列里是满的时候，存储元素的线程会阻塞等待队列变为可用状态

        LinkedBlockingQueue queue = new LinkedBlockingQueue(2);


        new QueueThread(queue).start();
        System.out.println("主线程执行结束");

    }

    static class QueueThread extends Thread{

        private LinkedBlockingQueue queue;

        public QueueThread(LinkedBlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 4; i++) {
                try {
//                    boolean success = queue.offer("hello world",2,TimeUnit.SECONDS);
                    boolean success = queue.offer("hello world");
                    System.out.println(success);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }


   /* static class MyThread extends Thread{
        private CountDownLatch latch;

        public MyThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(2000);

                System.out.println(getName() + " 执行结束");

                latch.countDown();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
*/

    static class MyThread1 extends Thread{
        private CyclicBarrier barrier;

        public MyThread1(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            super.run();
            try {
                System.out.println(getName() + " 开始执行");
                Thread.sleep(2000);
                barrier.await();
                System.out.println(getName() + " 结束执行");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
