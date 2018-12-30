package design_pattern.template_pattern;

public class Children extends Parent {


    @Override
    protected void step2() {
        System.out.println("第二部");
    }

    @Override
    protected void step4() {
        System.out.println("第四部");
    }

    @Override
    //挂载钩子
    protected boolean isNext() {
        return false;
    }
}
