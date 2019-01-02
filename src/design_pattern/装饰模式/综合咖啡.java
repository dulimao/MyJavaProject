package design_pattern.装饰模式;


/**
*@author: 杜立茂
*@createDate  : 2019/1/2 9:05
*@description: 被装饰者具体类1
*/

public class 综合咖啡 extends 咖啡{

    public 综合咖啡(){
        descripition = "综合咖啡";
    }

    @Override
    public double cost() {
        return 10.5;
    }
}
