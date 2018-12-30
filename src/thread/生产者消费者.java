package thread;



/**
*@Author: 杜立茂
*@CreateDate  : 2018/12/19 17:27
*@Description: 生产者消费者模型线程安全案例
*/

public class 生产者消费者 {

    public static void main(String[] args){
        Product product = new Product();//让生产者消费者同时持有同一产品
        Cunsumer customer = new Cunsumer(product);
        Producer producer = new Producer(product);
        customer.start();
        producer.start();
        /**
         * 问题一：此时会出现线程安全问题  消费者消费了 苹果 价格是： 2
         * 生产者生产了苹果，但是价格还没有修改，就被消费者消费了
         * 解决方案：用产品对象锁住代码块
         *
         * 问题二：生产者和消费者会连续生产和连续消费
         * 解决方案：使用线程等待/唤醒机制
         * wait()和notify(),notifyAll()方法是Object的方法，不是Thread的方法
         * 必须要在同步代码块和同步函数里面使用，必须要由“同一个锁对象”调用
         *
         * wait():让当前线程进入一个以对象锁为标识符的线程池中等待，释放资源
         * notify()：唤醒以对象锁为标识符的线程池中的一个线程
         * notifyAll():会唤醒线程池中的所有线程
         *
         * 线程停止：stop()方法可以停止线程，但是已经过时了，并且不安全
         *          interrupt()无法停止线程，作用是将阻塞状态的线程状态清除，在同步代码外面也可以调用
         *          一般通过设置标识来停止线程
         *
         * 守护线程：如果一个进程中只剩下守护线程，那么这个守护线程也会死亡
         *          如果一个线程需要随着主线程的死亡而死亡，则可以设置成守护线程 .setDaemon(true);
         * 线程让步：join()
         */
    }

}

/**
 * 产品
 */
class Product{
    public String name;
    public int price;
}

/**
 * 生产者
 */
class Producer extends Thread{
    Product p;
    public Producer(Product p){
        this.p = p;
    }
    @Override
    public void run() {
        super.run();
        int i = 0;
        while (true) {
            synchronized (p) {
                p.notify();
                if (i % 2 == 0) {
                    p.name = "苹果"; //------消费者夺取CPU执行权 问题一！！！
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    p.price = 6;
                } else {
                    p.name = "香蕉";
                    p.price = 2;
                }
                i++;
                System.out.println("生产者生产了 " + p.name + " 价格是 " + p.price);
                try {
                    p.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * 消费者
 */
class Cunsumer extends Thread{
    Product p;
    public Cunsumer(Product p){
        this.p = p;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            synchronized (p) {
                p.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者消费了 " + p.name + " 价格是： " + p.price);
                try {
                    p.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

