package design_pattern.proxy_pattern.static_proxy;

public class Car implements Moveable {
    @Override
    public void move() {
//        System.out.println("开始行驶");
        System.out.println("行驶中。。。");
//        System.out.println("行驶结束");
    }
}
