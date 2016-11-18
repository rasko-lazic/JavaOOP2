package homeworkA.cakery;

public class PlasmaCake extends Cake{

    public PlasmaCake() {
        super(new Ingredient[] {
                new Ingredient("plasma", 300, 6),
                new Ingredient("filling", 160, 2),
                new Ingredient("base", 120, 3)
        });

        System.out.println("Plasma cake is made.");
    }

    public String toString() {
        return "Plasma Cake";
    }
}
