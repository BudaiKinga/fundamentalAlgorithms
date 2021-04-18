package design.patterns.structural.proxy;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class MySpecificObject implements MyCommandInterface {


    @Override
    public void command1() {
        System.out.println("This can be accessed");
    }

    @Override
    public void command2() {
        System.out.println("This should be restricted!");
    }
}
