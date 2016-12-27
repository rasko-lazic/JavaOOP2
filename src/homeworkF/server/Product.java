package homeworkF.server;

import java.io.Serializable;

public class Product implements Serializable{

    private String name;
    private double price;
    private int amount;

    public Product(String n, double p, int a) {
        name = n;
        price = p;
        amount = a;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void decrementAmount() {
        amount--;
    }

    public String toString() {
        return "Product: " + name + " [price: " + price + "] [amount: " + amount + "]";
    }
}
