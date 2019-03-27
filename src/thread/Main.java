package thread;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
*@Author: 杜立茂
*@CreateDate  : 2018/12/19 9:19
*@Description: 进程：正在运行的程序,负责了内存空间的分配
 *             线程：负责了代码的执行，是进程中的一条执行路径
 *             一个Java程序至少有两个线程，main线程和gc线程
 *             多线程提高了资源利用率，而不是效率
 *             多线程弊端：1、CPU高速切换，增加了CPU的负担
 *                        2、存在线程安全问题，和死锁等问题
 *             线程的生命周期：新建，就绪(可运行)，运行，阻塞，销毁
 *             线程安全问题：多个线程同时操作同一共享资源
 *
 *             同步代码块：对象锁：任意一个对象都可以作为对象锁，
 *             因为每个对象内部都隐式的维护了一个state状态，
 *             而同步机制就是使用了对象的状态作为标识，而这种方式却降低了效率,
 *             对象锁必须是共享唯一的。
 *
 *             同步函数： 非静态函数的锁对象是this对象，也就是调用者，
 *                        静态函数的锁对象是当前类的字节码文件，也就是class对象
 *                        函数的锁对象是固定的
 *             推荐使用同步代码块
 *
 *             死锁：存在多个线程，并且多个线程共同操作两个以上的共享资源
 *
 *             推荐使用实现Runnable接口的方式
 *
 *             多线程实现方式：1：继承Thread,
 *                            2:实现Runnable接口（无返回值）
 *                            3：实现Callable(有返回值)
 *                            4：线程池（线程复用，减少线程的创建和切换，提高效率）
 *                               如：1000个线程线程池用时20毫秒左右，而普通线程需要500毫秒左右
 *             FutureTask，Worker,Callable
*/


class TCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        return "hello callable";
    }
}

public class Main {


    public static void main(String[] args){


        FutureTask task = new FutureTask(new TCallable());
        new Thread(task).start();
        try {
            System.out.println("返回结果：" + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

//        DeadLock deadLock1 = new DeadLock("张三");
//        DeadLock deadLock2 = new DeadLock("李四");
//        deadLock1.start();
//        deadLock2.start();
    }

    static class DeadLock extends Thread{
        public DeadLock(String name){
            super(name);
        }

        @Override
        public void run() {
            super.run();
            if ("张三".equals(this.getName())){
                synchronized ("遥控器"){
                    System.out.println("张三拿到了遥控器");
                    synchronized ("电池"){
                        System.out.println("张三拿到了电池和遥控器，在爽歪歪的吹着空调");
                    }
                }
            }else if ("李四".equals(this.getName())){
                synchronized ("电池"){
                    System.out.println("李四拿到了电池");
                    synchronized ("遥控器"){
                        System.out.println("李四拿到了电池和遥控器，吹着空调爽歪歪");
                    }
                }
            }
        }
    }

}
