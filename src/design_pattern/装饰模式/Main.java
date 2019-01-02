package design_pattern.装饰模式;

public class Main {

    public static void main(String[] args){
        //来一杯浓缩咖啡(什么都不加)
        咖啡 coffee = new 浓缩咖啡();
        System.out.println(coffee.descripition + " : " + coffee.cost());

        //来一杯综合咖啡(加牛奶和摩卡)
        咖啡 coffee1 = new 综合咖啡();
        coffee1 = new 牛奶(coffee1);
        coffee1 = new 摩卡(coffee1);
        System.out.println("我要一杯 " + (coffee1.getDescripition() + "  " + coffee1.cost()));
    }

}
