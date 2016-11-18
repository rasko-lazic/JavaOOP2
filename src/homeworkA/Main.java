package homeworkA;

import homeworkA.cakery.*;

public class Main {

    public static void main() {

        Cake chocolateCake = new ChocolateCake();
        Cake plasmaCake = new PlasmaCake();
        Cake capriCake = new CapriCake();

        Order order = new Order();

        order.orderCake(chocolateCake);
        order.orderCake(plasmaCake);
        order.orderCake(capriCake);

        order.printOrder();
    }
}
