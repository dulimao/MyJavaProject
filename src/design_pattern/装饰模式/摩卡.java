package design_pattern.装饰模式;


/**
*@author: 杜立茂
*@createDate  : 2019/1/2 9:12
*@description: 装饰者 2
*/

public class 摩卡 extends 调料 {

    private 咖啡 coffee;

    public 摩卡(咖啡 coffee){
        this.coffee = coffee;
    }

    @Override
    public String getDescripition() {
        return "摩卡 " + coffee.getDescripition();
    }

    @Override
    public double cost() {
        return .5 + coffee.cost();
    }
}
