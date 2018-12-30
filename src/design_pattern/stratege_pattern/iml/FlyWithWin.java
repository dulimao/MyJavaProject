package design_pattern.stratege_pattern.iml;

import design_pattern.stratege_pattern.FlyingStratege;

/**
 * 具体的策略类
 */
public class FlyWithWin implements FlyingStratege {
    @Override
    public void performFly() {
        //实现策略
        System.out.println("用翅膀飞");
    }
}
