package homeworkB.shop;

import homeworkA.cakery.Cake;

import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

public class CakeSales extends Thread{

    private static int idCounter = 0;
    private int sellerId;
    private ArrayList<Cake> saleStorage;
    private ArrayList<Cake> productionStorage;

    public CakeSales(ArrayList<Cake> s) {
        sellerId = idCounter++;
        saleStorage = new ArrayList<>(3);
        productionStorage = s;
    }

    public void run() {
        long now = System.currentTimeMillis();
        long end = now + 30000;

        while(System.currentTimeMillis() < end) {
            for(int i = 0; i < 3; i++) {
                Cake cakeForSale = takeFromStorage(productionStorage);

                saleStorage.add(cakeForSale);
            }

            System.out.println("Following cakes are sold " + saleStorage);
            saleStorage.clear();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Cake takeFromStorage(ArrayList<Cake> storage) {
        int index = storage.size();
        Cake cake;
        do {
            index--;
            cake = storage.get(index);
        } while (saleStorage.contains(cake));
        storage.remove(index);

        return cake;
    }
}
