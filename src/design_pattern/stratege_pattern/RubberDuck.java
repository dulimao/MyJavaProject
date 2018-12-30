package design_pattern.stratege_pattern;

import design_pattern.stratege_pattern.iml.FlyWithNoWay;
import design_pattern.stratege_pattern.iml.FlyWithWin;

public class RubberDuck extends Duck {

    public RubberDuck(){
        super.setFlyingStratege(new FlyWithNoWay());
    }

    @Override
    protected void display() {
        System.out.println("我是一只大黄鸭");
    }
}
