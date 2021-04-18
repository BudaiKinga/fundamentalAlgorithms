package design.patterns.structural.proxy;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class Proxy implements MyCommandInterface {

    private MySpecificObject omnipotentObj;
    private boolean allowToCall;

    Proxy(String user) {
        omnipotentObj = new MySpecificObject();
        allowToCall = "Kinga".equals(user);
    }

    @Override
    public void command1() {
        if (allowToCall) {
            omnipotentObj.command1();
        }
    }

    @Override
    public void command2() {
        System.out.println("Sorry, no access from proxy");
    }
}
