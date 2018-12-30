package design_pattern.template_pattern;


public abstract class Parent {

    protected final void templateMethod(){
        step1();

        step2();

        step3();

        if (isNext()){
            step4();
        }
    }

    private void step1(){
        System.out.println("第一步");

    }

    protected abstract void step2();

    private void step3(){
        System.out.println("第三步");

    }

    protected abstract void step4();


    /**
     * 钩子函数，由子类决定是否执行某些代码
     * @return
     */
    protected boolean isNext(){
        return true;
    }
}
