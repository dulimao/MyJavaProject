package tips.concurrent_demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
*@author: 杜立茂
*@createDate  : 2019/3/24 16:13
*@description: 等待超时示例/动态代理
*/

public class Demo11 {


    private static ConnectionPool pool = new ConnectionPool(10);
    //保证所有ConnectionRunner能够同时执行
    private static CountDownLatch start = new CountDownLatch(1);
    //main线程将会等待素所有ConnectionRunner结束才能继续执行
    private static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count,got,notGot),"ConnectionRunnerTrhead");
            thread.start();
        }

        start.countDown();
        end.await();
        System.out.println("total invoke:" + (threadCount * count));
        System.out.println("got connection:" + got);
        System.out.println("not got connection :" + notGot);
    }





    static class ConnectionRunner implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }


        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (count > 0) {
                Connection connection = null;
                try {
                    connection = pool.fetchConnection(1000);
                    if (connection != null){
                        connection.createStatement();
                        connection.commit();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally{
                    pool.releaseConnection(connection);
                    got.incrementAndGet();
                    count--;
                }
            }
            end.countDown();
        }
    }





    static class ConnectionPool{
        private static final LinkedList<Connection> pool = new LinkedList<>();
        public ConnectionPool(int initialSize){
            for (int i = 0; i < initialSize; i++){
                pool.addLast(ConnectionDriver.createConnection());
            }
        }

        public void releaseConnection(Connection connection){
            if (connection != null){
                synchronized (pool) {
                    //链接释放后要进行通知，让其他消费者线程能感知到连接池中已经归还了一个链接
                    pool.addLast(connection);
                    pool.notifyAll();
                }
            }
        }

        //等待超时机制
        public Connection fetchConnection(long ms) throws InterruptedException {
            synchronized (pool){
                //完全超时
                if (ms <= 0) {
                    while (pool.isEmpty()) {
                        pool.wait();
                    }
                    return pool.removeLast();
                } else {
                    long future = System.currentTimeMillis() + ms;
                    long remaining = ms;
                    while (pool.isEmpty() && remaining > 0){
                        pool.wait(remaining);
                        remaining = future - System.currentTimeMillis();
                    }
                    Connection result = null;
                    if (!pool.isEmpty()) {
                        result = pool.removeLast();
                    }
                    return result;
                }
            }
        }
    }


    //使用动态代理创建connection实例
    static class ConnectionDriver{
        static class ConnectionHandler implements InvocationHandler{

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("commit")){
                    TimeUnit.MILLISECONDS.sleep(1000);
                }
                return null;
            }
        }

        //创建一个Connection代理，在调用commit方法时休眠1000毫秒
        public static Connection createConnection(){
            return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
                    new Class[]{Connection.class},new ConnectionHandler());
        }
    }
}
