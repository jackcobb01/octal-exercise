import java.util.Vector;

public interface Observer {
    public Observer();
    public update();
    public String getValue();
}

public class Subject {
    private Vector<Observer> observers;
    public Subject();
    public attach(Observer observer) {
        this.observers.add(observer);
    }
    public sendNotice() {
        for (int i = 0; i < this.observers.length; i++) {
            this.observers[i].update();
        }
    }
    public int getState();
    public setState(int state);
}

public class NumberSubject extends Subject {
    private int state;
    public NumberSubject(int state) {
        this.state = state;
    }
    public int getState() {
        return this.state;
    }
    public setState(int state) {
        this.state = state;
        this.sendNotice();
    }
}

public class OctalObserver implements Observer {
    private String octValue;
    private Subject subject;
    public OctalObserver(Subject subject) {
        this.subject = subject;
    }
    public update() {
        this.octValue = Integer.toOctalString(this.subject.getState());
    }
    public String getValue() {
        return this.octValue;
    }
}
