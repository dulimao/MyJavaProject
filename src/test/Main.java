package test;


import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

class S{
    public String name;

    public S(String namne) {
        this.name = namne;
    }
}

class ChangeValue{
    String str = new String("hello");
    char[] ch = {'a','b','c'};
}

public class Main {


    public static void main(String[] args){
//        S s = new S("adu");
//        System.out.println(s.name);
//        test(s);
//        System.out.println(s.name);


//        ChangeValue ex = new ChangeValue();
//        change(ex.str,ex.ch);
//        System.out.println(ex.str);
//        System.out.println(ex.ch);


//        String s1 = "helloworld";
//        String s2 = "hello" + new String("world");
//        String s3 = "helloworld";
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s2 == s3);
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.equals(s3));

        S s = new S("axin");
//        WeakReference<S> ws = new WeakReference<>(s);//除了弱引用还持有强引用s,所以gc不会回收
        WeakReference<S> ws = new WeakReference<>(new S("axin"));//会被回收
        System.out.println(ws.get());
        System.gc();
        System.out.println(ws.get());

    }


    public static void change(String str,char[] ch) {
        str = "hello world";
        ch[0] = 'b';
        ch[1] = 'b';
    }

    public static void test(S s) {
        s.name = "axin";
    }

}




