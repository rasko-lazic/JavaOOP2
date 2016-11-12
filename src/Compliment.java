import java.util.TimerTask;

public class Compliment extends TimerTask {

    static int counter = 0;
    private String[] attributes = { "dobra", "lepa", "pametna", "zgodna", "slatka", "moja zena", };

    public void run() {
        System.out.println("Ana je " + attributes[counter]);

        counter++;
        if(counter > 5) {
            counter = 0;
        }
    }
}
