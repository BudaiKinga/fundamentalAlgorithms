package design.patterns.behavioral.strategy;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class TestStrategy {

    public static void main(String[] args) {
        PaymentStrategy p1 = new CardPayment();
        p1.pay();

        PaymentStrategy p2 = new CashPayment();
        p2.pay();
    }
}
