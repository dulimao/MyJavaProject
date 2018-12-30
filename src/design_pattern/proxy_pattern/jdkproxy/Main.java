package design_pattern.proxy_pattern.jdkproxy;

import design_pattern.proxy_pattern.static_proxy.Car;
import design_pattern.proxy_pattern.static_proxy.Moveable;

import java.lang.reflect.Proxy;

/**
 * JDK动态代理，在y原有逻辑前后增加额外功能，面向切面编程AOP
 */
public class Main {

    public static void main(String[] args){
        Car car = new Car();
        Class clazz = car.getClass();
        TimeHandler timeHandler = new TimeHandler(car);
        //产生动态代理类
        Moveable m = (Moveable) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),timeHandler);
        m.move();
    }
}
