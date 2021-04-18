package design.patterns.behavioral.observer;

import java.util.Observable;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class MySubject extends Observable {

    public void update() {
        setChanged();
        notifyObservers();
    }
}
