package design.patterns.behavioral.strategy;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class CashPayment implements PaymentStrategy {

    @Override
    public void pay() {
        System.out.println("Paid with cash");
    }
}
