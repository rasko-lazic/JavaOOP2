package exerciseA.geometry;


public class Point {

    private final int xCoordinate;
    private final int yCoordinate;

    public Point() {
        xCoordinate = 0;
        yCoordinate = 0;
    }

    public Point(int x, int y) {
        xCoordinate = x;
        yCoordinate = y;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public double getDistanceFromCoords(int x, int y) {
        return Math.sqrt(Math.pow((xCoordinate - x), 2) + Math.pow((yCoordinate - y), 2));
    }

    public double getDistanceFromPoint(Point p) {
        return Math.sqrt(Math.pow((xCoordinate - p.xCoordinate), 2) + Math.pow((yCoordinate - p.yCoordinate), 2));
    }

    public String toString() {
        return "t:(" + xCoordinate + ", " + yCoordinate + ")";
    }
}
