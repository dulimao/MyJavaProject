package tips;

import java.util.concurrent.TimeUnit;

public class Demo5 {

    public static void main(String[] args) throws InterruptedException {
//        //SleepRunner不定的尝试睡眠
//        Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
//        sleepThread.setDaemon(true);
//        sleepThread.start();
//        //休眠5秒，让SleepThread和busyThread充分运行
//        TimeUnit.SECONDS.sleep(5);
//        sleepThread.interrupt();
//        System.out.println("SleepThread isinterrupted is : " + sleepThread.isInterrupted()); //false
//        TimeUnit.SECONDS.sleep(5);

        Thread busyThread = new Thread(new BusyRunner(),"BusyThread");
        busyThread.setDaemon(true);
        busyThread.start();
        TimeUnit.SECONDS.sleep(2);
        busyThread.interrupt();
        System.out.println("BusyRunner isInterrupted is: " + busyThread.isInterrupted());//true
        TimeUnit.SECONDS.sleep(2);
    }

    //抛出InterruptedException的线程中断表示位会被清除，当调用interrupt()方法时，并不会中断
    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("SleepRunner is running");
                SleepUtils.second(1);
            }
        }
    }


    //中断表示位不会被清除，调用interrupt方法会将中断表示为置位：true
    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("BusyRunner is running");
            }
        }
    }
}
