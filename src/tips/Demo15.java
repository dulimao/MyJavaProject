package tips;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁:实现一个简单的缓存实例
 */
public class Demo15 {

    private static Map<String,Object> map = new HashMap<>();
    private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private static Lock readLock = rwl.readLock();
    private static Lock writeLock = rwl.writeLock();


    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new ReadRunner(),"ReaderThraed-" + i);
            thread.start();
        }

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new WriteRunner(),"WriteThread-" + i);
            thread.start();
        }


    }


    static class ReadRunner implements Runnable {

        @Override
        public void run() {
               String value = (String) get("key-WriteThread-3");
               System.out.println(Thread.currentThread().getName() + " value- " + value);
        }
    }

    static class WriteRunner implements Runnable {
        @Override
        public void run() {
            put("key-" + Thread.currentThread(),"value-" + Thread.currentThread());
            System.out.println(("key-" + Thread.currentThread().getName() + " value-" + Thread.currentThread().getName()));

        }
    }


    //获取一个key对应的value
    public static final Object get(String key) {
        readLock.lock();
        try {
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public static final Object put(String key,Object value) {
        writeLock.lock();
        try {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return map.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }


    public static final void clear() {
        writeLock.lock();
        try {
            map.clear();
        }finally {
            writeLock.unlock();
        }
    }


}
