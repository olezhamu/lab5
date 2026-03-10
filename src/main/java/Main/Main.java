package Main;

import Vehicle.*;
import Vehicle.VehicleType;

public class Main {
    public static void main(String[] args){
        /*
        Vehicle helicopter = new Vehicle("helicopter", 10, 20, 30, 40, 50, VehicleType.HELICOPTER);
        Vehicle submarine = new Vehicle("submarine", 1, 2, 3, 4, 60, VehicleType.SUBMARINE);
        Vehicle ship = new Vehicle("ship", 1, 2, 4, 4, 40, VehicleType.SHIP);

        new CollectionContainer().setCollection(new LinkedList<Vehicle>(Arrays.asList(helicopter, submarine)));

        System.out.println(new Info().execute());
        System.out.println(new Add(new Vehicle("vehicle", 1, 1, 1, 1, VehicleType.SUBMARINE)).execute());
        System.out.println(new Info().execute());
         */

        Vehicle vehicle = new Builder("name", 10.0, 10.0, 10, 10, VehicleType.HELICOPTER).build();

        System.out.println("finish");
    }
}