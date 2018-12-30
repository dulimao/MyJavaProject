package design_pattern.handlerchain_pattern;

public abstract class PriceHandler {

    protected PriceHandler handler;//直接后继



    public void setHandler(PriceHandler handler){
        this.handler = handler;
    }

    public abstract void hander(int num);


}
