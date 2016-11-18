package homeworkB.shop;

import java.util.Random;
import java.util.ArrayList;

import homeworkA.cakery.Cake;
import homeworkA.cakery.CapriCake;
import homeworkA.cakery.ChocolateCake;
import homeworkA.cakery.PlasmaCake;

public class CakeProduction extends Thread {

    private ArrayList<Cake> storage;

    public CakeProduction() {
        storage = new ArrayList<>();
    }

    public ArrayList<Cake> getStorage() {
        return storage;
    }

    public void run() {

        Random random = new Random();

        long now = System.currentTimeMillis();
        long end = now + 30000;

        try {
            while(System.currentTimeMillis() < end) {

                int randomInt = random.nextInt(3);
                storage.add(this.cakeFromInt(randomInt));

                Thread.sleep(250);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Cake cakeFromInt(int n) {
        Cake cake;

        switch (n) {
            case 0:
                cake = new ChocolateCake();
                break;

            case 1:
                cake = new PlasmaCake();
                break;

            case 2:
                cake = new CapriCake();
                break;

            default:
                cake = new ChocolateCake();
        }

        return cake;
    }
}
