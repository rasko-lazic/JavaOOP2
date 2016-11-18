package homeworkA.cakery;

public class ChocolateCake extends Cake{

    public ChocolateCake() {

        super(new Ingredient[] {
                new Ingredient("chocolate", 350, 4),
                new Ingredient("filling", 120, 2),
                new Ingredient("base", 140, 3)
        });

        System.out.println("Chocolate cake is made.");
    }

    public String toString() {
        return "Chocolate Cake";
    }
}


