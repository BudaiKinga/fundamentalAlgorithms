package design.patterns.structural.decorator;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class DecoraterExample {

    public static void main(String[] args) {
        Car sportCar = new SportsCarDecorator(new BasicCar());
        sportCar.asemble();

        System.out.println();

        Car sportAndLuxuryCar = new SportsCarDecorator(new LuxuryCarDecorator(new BasicCar()));
        sportAndLuxuryCar.asemble();
    }
}
