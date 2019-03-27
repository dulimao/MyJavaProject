package test;

import javafx.concurrent.Task;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.*;

public class ClassTest {

    public static void main(String[] args){
        //Class[] clazz = {A.class,B.class};


//        A ab = new B();
//        ab = new B();
//        //面试题：引用父类静态变量的时候会不会实例化子类？ 答案：不会
        String s = B.name;
        System.out.println(s);//Static A
        Person person = new Person("adu");


        ReferenceQueue<Person> personReferenceQueue = new ReferenceQueue<>();
        WeakReference<Person> refPerson = new WeakReference<>(new Person("adu"),personReferenceQueue);
        System.out.println(refPerson.get());
//        person = null;
        System.gc();
        System.out.println(refPerson.get());
        System.out.println(personReferenceQueue.poll());
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                    System.out.println(personReferenceQueue.poll());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        M m = new M(){


            @Override
            public void hello(String msg) {
                System.out.println(msg);
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
       Future<Integer> future = executorService.submit(new MyCallable());
       Future<Integer> future1 = executorService.submit(new MyCallable());

        try {
            System.out.println(future.get() + future1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask).start();
        try {
            System.out.println("运算结果"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


     static interface M{


         void hello(String msg);

    }

    static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            return 1 + 3;
        }
    }
}
