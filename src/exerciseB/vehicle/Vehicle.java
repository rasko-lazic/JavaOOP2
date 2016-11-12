package exerciseB.vehicle;

public abstract class Vehicle {

    private String type;
    private String brand;
    private int length;
    private int width;

    public Vehicle(int l, int w, String b, String t) {
        length = l;
        width = w;
        brand = b;
        type = t;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String toString() {
        return type + ": (" + brand + ", " + length + ", " + width + ")";
    }
}
