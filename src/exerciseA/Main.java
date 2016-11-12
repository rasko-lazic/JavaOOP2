package exerciseA;

import exerciseA.geometry.*;

public class Main {

    public static void main() {
        Point p1 = new Point();
        System.out.println(p1);

        Triangle t1 = new Triangle();
        Triangle t2 = new Triangle(13, 16, 23, 30, 50, 25);
        Triangle t3 = new Triangle(25, 21, 11, 30, 39, 27);

        Triangle[] array = {t1, t2, t3};

        Triangle tMax = Triangle.getLargest(array);

        System.out.println("The largest triangle is " + tMax + " and it has area of " + tMax.getTriangleArea());
    }
}
