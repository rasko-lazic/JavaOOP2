package homeworkB;

import homeworkB.shop.CakeProduction;
import homeworkB.shop.CakeSales;

import static java.lang.Thread.sleep;

public class Main {

    public static void main() {
        CakeProduction shop = new CakeProduction();
        CakeSales seller = new CakeSales(shop.getStorage());

        shop.start();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        seller.start();
    }
}
