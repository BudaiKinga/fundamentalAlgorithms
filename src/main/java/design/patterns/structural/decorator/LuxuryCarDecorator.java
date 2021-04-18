package design.patterns.structural.decorator;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class LuxuryCarDecorator extends CarDecorator {

    public LuxuryCarDecorator(Car c) {
        super(c);
    }


    @Override
    public void asemble() {
        System.out.println("First add superclass decorator");
        super.asemble();
        System.out.println("This is a luxury car");
    }
}
