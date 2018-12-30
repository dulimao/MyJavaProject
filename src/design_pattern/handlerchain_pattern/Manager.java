package design_pattern.handlerchain_pattern;

public class Manager extends PriceHandler {


    @Override
    public void hander(int num) {
        if (num < 20){
            System.out.println(this.getClass().getSimpleName() + " 打了20折");
        }else{
            this.handler.hander(num);
        }
    }
}
