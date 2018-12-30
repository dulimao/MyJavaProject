package design_pattern.observer_patter;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> list = new ArrayList<>();

    public void attach(Observer observer){
        list.add(observer);
    }

    public void detach(Observer observer){
        list.remove(observer);
    }

    public void notifyObservers(){//可以申明为抽象方法，放到子类去，做一些扩展的操作
        for (Observer observer :
                list) {
            observer.update(this);
        }
    }
}
