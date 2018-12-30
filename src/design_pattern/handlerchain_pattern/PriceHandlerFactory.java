package design_pattern.handlerchain_pattern;


//单一职责原则
public class PriceHandlerFactory {


    /**
     * 生产Handler的工厂方法
     * @return
     */
    public static PriceHandler createHandler() {
        Sales sales = new Sales();
        Manager manager = new Manager();
        CEO ceo = new CEO();

        sales.setHandler(manager);
        manager.setHandler(ceo);
        return sales;
    }
}
