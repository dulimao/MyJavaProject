package test;

public class A {

    protected static String name = "hello";

    static {
        System.out.println("Static A");
    }

    public A(){
        System.out.println("A");
    }
}
