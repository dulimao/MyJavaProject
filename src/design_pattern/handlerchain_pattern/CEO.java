package design_pattern.handlerchain_pattern;

public class CEO extends PriceHandler {


    @Override
    public void hander(int num) {
        if (num < 50){
            System.out.println(this.getClass().getSimpleName() + " 打了50折");
        }else{
            System.out.println("CEO拒绝了这个请求");
        }
    }
}
