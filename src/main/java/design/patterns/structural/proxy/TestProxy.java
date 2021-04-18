package design.patterns.structural.proxy;

/**
 * Created by BudaiK on Nov, 2020.
 */
public class TestProxy {

    public static void main(String[] args) {
        MyCommandInterface proxyObj = new Proxy("Kinga");
        proxyObj.command1();
        proxyObj.command2();

        MyCommandInterface proxyObj2 = new Proxy("Boldi");
        proxyObj2.command1();
        proxyObj2.command2();
    }
}
