package design_pattern.proxy_pattern.static_proxy;

public class BigCar implements Moveable {

    private Car car;

    public BigCar(Car car){
        this.car = car;
    }

    @Override
    public void move() {
        System.out.println("开始行驶");
        car.move();
        System.out.println("行驶结束");
    }
}
