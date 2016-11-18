package klkI.monte_carlo;

import java.util.Random;

public class Simulation {

    public static void run() {
        Dot randomDot;
        Random random = new Random();
        long inCircleCounter = 0;

        for(long i = 0; i < 100000; i++) {
            double xCoordinate = ((random.nextDouble() * 10) - 5);
            double yCoordinate = ((random.nextDouble() * 10) - 5);

            randomDot = new Dot(xCoordinate, yCoordinate);
            double distance = randomDot.getDistanceFromZero();

            if(distance < 5) {
                inCircleCounter++;
            }
        }

        double ratio = inCircleCounter / 100000.00;
        System.out.println("PI approximation: " + ratio * 4);
    }
}
