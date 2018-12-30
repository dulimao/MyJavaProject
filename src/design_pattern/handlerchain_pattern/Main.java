package design_pattern.handlerchain_pattern;

import java.util.Random;

/**
 * 责任链模式 缺点：时间损耗，性能开销大，创建多个handler，但只用其中一个
 */
public class Main {
    public static void main(String[] args){
        Customer customer = new Customer();
        customer.setPriceHandler(PriceHandlerFactory.createHandler());
        customer.request(new Random().nextInt(80));
    }
}
