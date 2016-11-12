package exerciseB;

import exerciseB.parking.ParkingLot;
import exerciseB.vehicle.Bus;
import exerciseB.vehicle.Truck;
import exerciseB.vehicle.Vehicle;

public class Main {

    public static void main() {
        ParkingLot lot = new ParkingLot(5);

        System.out.println("Empty parking lot: ");
        lot.showSpaces();

        Vehicle bus1 = new Bus("Mercedes");
        Vehicle bus2 = new Bus("Volvo");
        Vehicle truck1 = new Truck("FAP");

        lot.parkOnFirstAvailable(bus1);
        lot.parkOnFirstAvailable(bus2);
        lot.parkOnFirstAvailable(truck1);

        lot.showSpaces();
        lot.saveData();
    }
}
