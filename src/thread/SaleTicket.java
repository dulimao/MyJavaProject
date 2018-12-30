package thread;

/**
*@Author: 杜立茂
*@CreateDate  : 2018/12/19 16:54
*@Description: 售票方式二：不存在线程安全问题
*/

class SaleRunable implements Runnable{

    int num = 50;
    @Override
    public void run() {
        while (true) {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "当前售卖的是 " + num-- + "号票");
            } else {
                System.out.println(Thread.currentThread().getName() + "售罄了");
                break;
            }
        }

    }
}

/**
*@Author: 杜立茂
*@CreateDate  : 2018/12/19 16:45
*@Description: 售票方式一
*/

public class SaleTicket extends Thread {


    static Object object = new Object();

    public static void main(String[] args){

        SaleRunable saleRunable = new SaleRunable();
        new Thread(saleRunable,"狗娃").start();
        new Thread(saleRunable,"狗剩").start();
//        SaleTicket saleTicket1 = new SaleTicket("窗口1");
//        SaleTicket saleTicket2 = new SaleTicket("窗口2");
//        SaleTicket saleTicket3 = new SaleTicket("窗口3");
//        saleTicket1.start();
//        saleTicket2.start();
//        saleTicket3.start();
    }

    private static int num = 50;

    public SaleTicket(String name){
        super(name);
    }

    @Override
    public void run() {
        super.run();
        while (true) {
        synchronized (object){
                if (num > 0) {
                    System.out.println(this.getName() + "  卖了 " + num-- + " 张票");
                } else {
                    System.out.println("售罄了");
                    break;
                }
            }
        }

    }
}
