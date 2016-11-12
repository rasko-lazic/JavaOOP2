package homeworkA;

import homeworkA.cakery.*;

public class Main {

    public static void main() {
        Ingredient[] ingredientList1 = {
                new Ingredient("chocolate", 350, 4),
                new Ingredient("filling", 120, 2),
                new Ingredient("base", 140, 3),
        };
        Cake chocolateCake = new ChocolateCake(ingredientList1);

        Ingredient[] ingredientList2 = {
                new Ingredient("plasma", 300, 6),
                new Ingredient("filling", 160, 2),
                new Ingredient("base", 120, 3),
        };
        Cake plasmaCake = new PlasmaCake(ingredientList2);

        Order order = new Order();

        order.orderCake(chocolateCake);
        order.orderCake(plasmaCake);
        order.printOrder();
    }
}
