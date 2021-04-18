package design.patterns.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class TestObserver {

    public static void main(String[] args) {
        MySubject subj = new MySubject();
        Observer obs1 = new MyObserver("obs 1");
        Observer obs2 = new MyObserver("obs 2");
        subj.addObserver(obs1);
        subj.addObserver(obs2);

        subj.update();
    }
}
