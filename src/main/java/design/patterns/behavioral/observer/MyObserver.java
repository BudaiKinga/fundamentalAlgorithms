package design.patterns.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class MyObserver implements Observer {

    private String name;

    MyObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Observer " + name + " is notified");
    }
}
