package tips;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 多线程操作HashMap，导致死循环
 */
public class Demo18 {

    private static final Map<String,String> map = new HashMap<>(2);//HashMap:线程不安全, ConcurrentHashMap:分段锁机制

    public static void main(String[] args) throws InterruptedException {
        Demo10.Profiler.begin();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String uuid = UUID.randomUUID().toString();
                            System.out.println(uuid);
                            map.put(uuid,"");
                        }
                    }).start();
                }
            }
        });
        t.start();
        t.join();
        long time = Demo10.Profiler.end();
        System.out.println("time: " + time);

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1000,true);





    }

}
