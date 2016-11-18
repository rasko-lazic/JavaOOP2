package homeworkA.cakery;

public class CapriCake extends Cake{

    public CapriCake() {
        super(new Ingredient[] {
                new Ingredient("fruit", 350, 5),
                new Ingredient("filling", 120, 2),
                new Ingredient("base", 130, 3)
        });

        System.out.println("Capri cake is made.");
    }

    public String toString() {
        return "Capri Cake";
    }
}
