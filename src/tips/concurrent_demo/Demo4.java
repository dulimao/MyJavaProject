package tips.concurrent_demo;


/**
*@author: 杜立茂
*@createDate  : 2019/3/24 11:24
*@description: 守护线程在主线程退出时，也会终止，并且finally方法不一定会执行
*/

public class Demo4 {


    public static void main(String[] args){
        Thread thread = new Thread(new DaemonRunner(),"DaemonThread");
        thread.setDaemon(true);
        thread.start();
        System.out.println("MainThread end");
    }


    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {

                    Thread.sleep(1000);
                    System.out.println("DaemonThread running");
                }
            } catch (InterruptedException e) {

            }finally {
                System.out.println("DaemonThread finally run");
            }
        }
    }
}
