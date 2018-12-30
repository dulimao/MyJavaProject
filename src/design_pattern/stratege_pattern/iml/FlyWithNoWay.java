package design_pattern.stratege_pattern.iml;

import design_pattern.stratege_pattern.FlyingStratege;

public class FlyWithNoWay implements FlyingStratege {

    @Override
    public void performFly() {
        System.out.println("我不会飞行");
    }
}
