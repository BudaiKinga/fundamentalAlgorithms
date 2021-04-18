package design.patterns.structural.decorator;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class BasicCar implements Car {
    @Override
    public void asemble() {
        System.out.println("This is a basic car");
    }
}
