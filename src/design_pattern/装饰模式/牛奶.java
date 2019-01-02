package design_pattern.装饰模式;


/**
*@author: 杜立茂
*@createDate  : 2019/1/2 9:10
*@description: 装饰者具体类 1
*/

public class 牛奶 extends 调料{

    private 咖啡 coffee;

    public 牛奶(咖啡 coffee){
        this.coffee = coffee;
    }

    @Override
    public String getDescripition() {
        return "牛奶 " + coffee.getDescripition();
    }

    @Override
    public double cost() {
        return 1.0 + coffee.cost();
    }
}
