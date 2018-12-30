package design_pattern.stratege_pattern;

/**
 * 复合尤于继承，多用组合，少用继承
 */
public abstract class Duck {

    private FlyingStratege flyingStratege;



    protected void quack(){
        System.out.println("嘎嘎嘎、、、");
    }

    protected abstract void display();

    protected void setFlyingStratege(FlyingStratege flyingStratege) {
        this.flyingStratege = flyingStratege;
    }

    //具有特定行为，但是行为策略抽象成接口，灵活多变
    public void fly(){
        flyingStratege.performFly();
    }
}
