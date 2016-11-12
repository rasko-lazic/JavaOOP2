package exerciseB.parking;

import exerciseB.vehicle.Vehicle;

public class ParkingSpot {

    private static int IDIncrement = 0;
    private final int ID;
    private int width;
    private int length;
    private boolean occupied;
    private Vehicle parked;

    public ParkingSpot() {
        ID = IDIncrement;
        width = 2;
        length = 4;
        occupied = false;
        parked = null;

        IDIncrement++;
    }

    public ParkingSpot(int w, int l) {
        ID = IDIncrement;
        width = w;
        length = l;
        occupied = false;
        parked = null;

        IDIncrement++;
    }

    public int getID() {
        return ID;
    }

    public boolean isFree() {
        return ! occupied;
    }

    public boolean canItFit(Vehicle v) {
        if(v.getLength() <= length && v.getWidth() <= width) {
            return true;
        } else {
            return false;
        }
    }

    public boolean park(Vehicle v) {
        if(this.canItFit(v) && this.isFree()) {
            occupied = true;
            parked = v;

            return true;
        } else {
            return false;
        }
    }

    public boolean unpark() {
        if(this.occupied) {
            occupied = false;
            parked = null;

            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        if(occupied) {
            return ID + "[" + width + ", " + length + "] => " + parked.getType() + "(" +
                    parked.getBrand() + ", " + parked.getWidth() + ", " + parked.getLength() + ")";
        } else {
            return ID + "[" + width + ", " + length + "]";
        }
    }
}
