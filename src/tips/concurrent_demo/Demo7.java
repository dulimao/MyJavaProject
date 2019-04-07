package tips.concurrent_demo;


/**
*@author: 杜立茂
*@createDate  : 2019/3/24 13:47
*@description: 查看字节码结构：javap -v Demo7.class
*/

public class Demo7 {

    public static void main(String[] args) {

        synchronized (Demo7.class){
            System.out.println("同步代码块");
        }

        methodA();

    }

    public static synchronized void methodA() {
        System.out.println("同步方法methodA");
    }
}
