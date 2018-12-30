package design_pattern.proxy_pattern.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 具体业务处理器
 */
public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("计时开始");
        method.invoke(target);
        System.out.println("计时结束");
        return null;
    }
}
