package exerciseB.parking;

import exerciseB.vehicle.Vehicle;
import java.io.PrintWriter;

public class ParkingLot {

    private final int spacesCount;
    private ParkingSpot spots[] = null;

    public ParkingLot() {
        spacesCount = 20;
        spots = new ParkingSpot[spacesCount];

        for(int i = 0; i < 20; i++) {
            spots[i] = new ParkingSpot();
        }
    }

    public ParkingLot(int n) {
        spacesCount = n;
        spots = new ParkingSpot[n];

        for(int i = 0; i < n; i++) {
            spots[i] = new ParkingSpot();
        }
    }

    public void parkOnFirstAvailable(Vehicle v) {
        boolean parked = false;
        for(ParkingSpot spot : spots) {
            parked = spot.park(v);
            if(parked) {
                break;
            }
        }

        String result = parked ? "Vehicle was parked successfully" : "Unable to find parking spot for vehicle";
        System.out.println(result);
    }

    public void unparkOnId(int id) {
        String result = "";

        for(ParkingSpot spot : spots) {
            if(spot.getID() == id) {
                if(! spot.isFree()) {
                    spot.unpark();
                    result = "Vehicle unparked.";
                } else {
                    result = "Specified spot is free.";
                }
            } else {
                result = "Spot doesn't exist";
            }
        }

        System.out.println(result);
    }

    public void showSpaces() {
        for(ParkingSpot spot : spots) {
            if(spot.isFree()) {
                System.out.println(spot);
            }
        }

        for(ParkingSpot spot : spots) {
            if(! spot.isFree()) {
                System.out.println(spot);
            }
        }
    }

    public void saveData() {
        try {
            PrintWriter writer = new PrintWriter("data.txt", "UTF-8");
            for (ParkingSpot spot : spots) {
                writer.println(spot);
            }
            writer.close();

        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}
