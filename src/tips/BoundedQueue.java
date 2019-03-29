package tips;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟有界阻塞队列
 * @param <T>
 */
public class BoundedQueue<T> {
    private Object[] items;
    private int addIndex;
    private int removeIndex;
    private int count;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();



    public static void main(String[] args) {
        BoundedQueue<Integer> queue = new BoundedQueue<>(5);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        queue.add(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        queue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


    public BoundedQueue(int size) {
        items = new Object[size];
    }

    //添加一个元素，如果数组满，则添加线程进入等待状态，知道有“空位”
    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                System.out.println("add thread is waiting");
                notFull.await();
            }
            items[addIndex] = t;
            System.out.println("add thread is add one element");
            if (++addIndex == items.length) {
                addIndex = 0;
            }
            count++;
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }


    //由头部删除一个元素，如果数组为空，则删除线程进入等待状态，知道有新的元素添加
    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                System.out.println("remove thread is waiting");
                notEmpty.await();
            }
            Object x = items[removeIndex];
            if (++removeIndex == items.length) {
                removeIndex = 0;
            }
            System.out.println("remove thread remove one element");
            --count;
            notFull.signal();
            return (T) x;
        }finally{
            lock.unlock();
        }
    }
}
