package exerciseA.geometry;

import java.util.Arrays;

public class Triangle {

    private Point a;
    private Point b;
    private Point c;

    public Triangle() {
        a = new Point();
        b = new Point(0, 5);
        c = new Point(5, 0);
    }

    public Triangle(int aX, int aY, int bX, int bY, int cX, int cY) {
        a = new Point(aX, aY);
        b = new Point(bX, bY);
        c = new Point(cX, cY);
    }

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isRightAngled() {
        double[] sideLengths = {};

        sideLengths[0] = a.getDistanceFromPoint(b);
        sideLengths[1] = a.getDistanceFromPoint(c);
        sideLengths[2] = b.getDistanceFromPoint(c);

        Arrays.sort(sideLengths);

        return Math.pow(sideLengths[2], 2) == Math.sqrt(Math.pow(sideLengths[0], 2) + Math.pow(sideLengths[1], 2));
    }

    public boolean samePoint(Triangle t) {
        if(a.getDistanceFromPoint(t.a) == 0) return true;
        if(a.getDistanceFromPoint(t.a) == 0) return true;
        if(a.getDistanceFromPoint(t.a) == 0) return true;

        if(b.getDistanceFromPoint(t.a) == 0) return true;
        if(b.getDistanceFromPoint(t.a) == 0) return true;
        if(b.getDistanceFromPoint(t.a) == 0) return true;

        if(c.getDistanceFromPoint(t.a) == 0) return true;
        if(c.getDistanceFromPoint(t.a) == 0) return true;
        if(c.getDistanceFromPoint(t.a) == 0) return true;

        return false;
    }

    public double getHalfSide() {
        double sideSum = a.getDistanceFromPoint(b) + a.getDistanceFromPoint(c) + b.getDistanceFromPoint(c);

        return sideSum / 2;
    }

    public double getTriangleArea() {
        double halfSide = this.getHalfSide();

        return Math.sqrt(halfSide * (halfSide - a.getDistanceFromPoint(b)) * (halfSide - a.getDistanceFromPoint(c))
                * (halfSide - b.getDistanceFromPoint(c)));
    }

    public static Triangle getLargest(Triangle[] triangleArray) {
        double maxArea = 0;
        int counter = 0;
        int maxIndex = 0;

        for (Triangle t : triangleArray) {
            double area = t.getTriangleArea();

            if(area > maxArea) {
                maxArea = area;
                maxIndex = counter;
            }

            counter++;
        }

        return triangleArray[maxIndex];
    }

    public String toString() {
        return "T: [" + a.toString() + ", " + b.toString() + ", " + c.toString() + "]";
    }
}
