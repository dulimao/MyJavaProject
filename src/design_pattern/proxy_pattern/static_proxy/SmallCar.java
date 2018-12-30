package design_pattern.proxy_pattern.static_proxy;

public class SmallCar extends Car {

    @Override
    public void move() {
        System.out.println("开始行驶");
        super.move();
        System.out.println("行驶结束");
    }
}
