package design_pattern.proxy_pattern.static_proxy;

/**
 * 时间代理类
 */
public class CarTilmeProxy implements Moveable{


    private Moveable m;

    public CarTilmeProxy(Moveable m){
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("计时开始");
        m.move();
        System.out.print("计时结束");
    }
}
