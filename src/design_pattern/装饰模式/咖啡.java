package design_pattern.装饰模式;


/**
*@author: 杜立茂
*@createDate  : 2019/1/2 9:03
*@description: 被装饰者抽象基类
*/

public abstract class 咖啡 {

    public String descripition;

    public String getDescripition(){
        return descripition;
    }

    //计算饮料价格
    public abstract double cost();

}
