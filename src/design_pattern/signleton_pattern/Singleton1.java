package design_pattern.signleton_pattern;

/**
*@author: 杜立茂
*@createDate  : 2019/1/14 13:13
*@description: 单例模式--静态内部类方式
*/

public class Singleton1 {

    private Singleton1(){}

    private static class SingletonHolder{
        private static Singleton1 instance = new Singleton1();
    }

    public static Singleton1 getInstance(){
        return SingletonHolder.instance;
    }
}
