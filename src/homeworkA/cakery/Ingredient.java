package homeworkA.cakery;

public class Ingredient {

    private String name;
    private int amount;
    private int price;

    public Ingredient(String n, int a, int p) {
        name = n;
        amount = a;
        price = p;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }
}
