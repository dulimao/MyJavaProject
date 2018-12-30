package design_pattern.handlerchain_pattern;

public class Customer {

    private PriceHandler priceHandler;

    public void setPriceHandler(PriceHandler priceHandler){
        this.priceHandler = priceHandler;
    }

    public void request(int num){
        priceHandler.hander(num);
    }

}
