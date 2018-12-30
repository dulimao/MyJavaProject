package design_pattern.observer_patter;


public class ConcreateObserver implements Observer {


    @Override
    public void update(Subject subject) {
        System.out.println("接收到的内容： " + ((ConcreateSubject)subject).getContent());
    }
}
