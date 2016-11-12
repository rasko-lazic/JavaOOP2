package homeworkA.cakery;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Order {

    private ArrayList<Cake> orderList;

    public Order() {
        orderList = new ArrayList<>();
    }

    public void orderCake(Cake c) {
        orderList.add(c);
    }

    public void printOrder() {
        try {
            PrintWriter writer = new PrintWriter("invoice.txt", "UTF-8");

            int totalPrice = 0;

            for(Cake cake : orderList) {
                writer.println(cake);
                totalPrice += cake.getPrice();
            }

            writer.println("Total price: " + totalPrice * 1.1);

            writer.close();
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}
