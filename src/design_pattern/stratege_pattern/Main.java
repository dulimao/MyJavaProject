package design_pattern.stratege_pattern;

/**
 * 测略模式：将可变的部分抽象分离成算法接口，在该接口下分别封装一系列算法实现，使得客户端程序独立于算法实现 如：不同的支付方式
 */
public class Main {

    public static void main(String[] args){
//        Duck duck = new RedDuck();
        Duck duck = new RubberDuck();
        duck.quack();
        duck.display();
        duck.fly();
    }
}
