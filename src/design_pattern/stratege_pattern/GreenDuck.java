package design_pattern.stratege_pattern;

import design_pattern.stratege_pattern.iml.FlyWithWin;

public class GreenDuck extends Duck {

    public GreenDuck(){
        super.setFlyingStratege(new FlyWithWin());
    }

    @Override
    protected void display() {
        System.out.println("我是绿脖鸭");

    }
}
