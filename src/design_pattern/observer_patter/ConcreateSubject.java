package design_pattern.observer_patter;

public class ConcreateSubject extends Subject{
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.notifyObservers();
    }
}
