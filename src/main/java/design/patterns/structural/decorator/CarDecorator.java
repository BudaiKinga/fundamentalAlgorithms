package design.patterns.structural.decorator;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class CarDecorator implements Car {

    private Car c;

    public CarDecorator(Car c) {
        this.c = c;
    }

    @Override
    public void asemble() {
        this.c.asemble();
    }
}
