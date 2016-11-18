package klkI.monte_carlo;

public class Dot {

    private double xCoordinate;
    private double yCoordinate;

    public Dot(double x, double y) {
        xCoordinate = x;
        yCoordinate = y;
    }

    public double getDistanceFromZero() {
        return Math.sqrt(Math.pow(xCoordinate, 2) + Math.pow(yCoordinate, 2));
    }
}
