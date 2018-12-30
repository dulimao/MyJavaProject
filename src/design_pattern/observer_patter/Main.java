package design_pattern.observer_patter;

public class Main {
    //观察者模式
    public static void main(String[] args){
        ConcreateSubject subject = new ConcreateSubject();

        ConcreateObserver observer = new ConcreateObserver();

        ConcreateObserver observer1 = new ConcreateObserver();


        subject.attach(observer);
        subject.attach(observer1);
        subject.setContent("hello 你好，今天的内容讲的是观察者模式");
    }
}
