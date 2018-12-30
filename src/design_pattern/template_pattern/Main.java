package design_pattern.template_pattern;

/**
 * 模板方法模式：定义一个模板框架，留出不确定的方法让子类实现
 */
public class Main {
    public static void main(String[] args){
        Children children = new Children();
        children.templateMethod();
    }
}
