package design_pattern.handlerchain_pattern;

public class Sales extends PriceHandler {


    @Override
    public void hander(int num) {
        if (num < 10){
            System.out.println(this.getClass().getSimpleName() + " 打了10折");
        }else{
            this.handler.hander(num);
        }
    }
}
