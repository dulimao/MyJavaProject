package design_pattern.proxy_pattern.static_proxy;

public class Main {

    public static void main(String[] args){
//        SmallCar car = new SmallCar();//继承--静态代理
//        car.move();

//        BigCar bigCar = new BigCar(new Car());//聚合 --静态代理
//        bigCar.move();

        Car car = new Car();
        //日志，计时代理，可以在具体的操作前后做相应的事情，但是存在缺陷，扩展性不强，需使用动态代理
        CarTilmeProxy tilmeProxy = new CarTilmeProxy(car);
        CarLogProxy carLogProxy = new CarLogProxy(tilmeProxy);
        carLogProxy.move();
    }
}
