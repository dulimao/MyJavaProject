package design_pattern.stratege_pattern;

import design_pattern.stratege_pattern.iml.FlyWithWin;

public class RedDuck extends Duck {

    public RedDuck(){
        super.setFlyingStratege(new FlyWithWin());
    }

    @Override
    protected void display() {
        System.out.println("我是红脖鸭");

    }
}
