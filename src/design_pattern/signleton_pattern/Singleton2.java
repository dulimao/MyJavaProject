package design_pattern.signleton_pattern;

/**
*@author: 杜立茂
*@createDate  : 2019/1/14 13:16
*@description: 单例模式---双重检查方式
*/

public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2(){}

    public static  Singleton2 getInstance(){
        if (instance == null){
            synchronized (Singleton2.class){
                if (instance == null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }

}
