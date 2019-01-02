package design_pattern.装饰模式;


/**
*@author: 杜立茂
*@createDate  : 2019/1/2 9:07
*@description: 被装饰者具体类2
*/

public class 浓缩咖啡 extends 咖啡 {

    public 浓缩咖啡(){
        descripition = "浓缩咖啡";
    }

    @Override
    public double cost() {
        return 8.6;
    }
}
