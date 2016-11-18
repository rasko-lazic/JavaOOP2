package homeworkA.cakery;

public abstract class Cake {

    private Ingredient[] ingredients;

    public Cake(Ingredient[] i) {

        ingredients = i;
    }

    public int getPrice() {
        int price = 0;

        for(Ingredient ingredient : ingredients) {
            price += ingredient.getAmount() * ingredient.getPrice();
        }

        return price;
    }
}
