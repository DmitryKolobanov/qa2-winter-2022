package vehicles;

import org.junit.jupiter.api.Test;

public class Calculation {
    @Test
    public void calculatingRoute() {
        //---------------- Transpot -----------------
        Transport car = new Transport();
        car.setVehicleType("Car");
        car.setTankVolume(50);
        car.setFuelConsumption(6.5);
        Transport train = new Transport();
        train.setVehicleType("Train");
        train.setTankVolume(2000);
        train.setFuelConsumption(300);
        Transport airplane = new Transport();
        airplane.setVehicleType("Airplane");
        airplane.setTankVolume(10000);
        airplane.setFuelConsumption(500);

        //---------------- Routes -----------------
        Route rigaDepils = new Route();
        rigaDepils.setRouteName("Riga - Daugavpils");
        rigaDepils.setDistance(250);
        Route rigaPiter = new Route();
        rigaPiter.setRouteName("Riga - Sankt-Petersburg");
        rigaPiter.setDistance(550);
        Route rigaMoscow = new Route();
        rigaMoscow.setRouteName("Riga - Moscow");
        rigaMoscow.setDistance(1000);

        //---------------- Output -----------------

        System.out.println(rigaDepils.getRouteName());
        System.out.println(" ");
        System.out.println(car.getVehicleType() + (": ") + (rigaDepils.getDistance() / 100 * (car.getFuelConsumption())) + (" Liters needed"));
        System.out.println(("Tank Volume: ") + (car.getTankVolume()) + (" Liters"));
        if ((rigaDepils.getDistance() / 100 * (car.getFuelConsumption()) < car.getTankVolume())) {
            System.out.println("Enough Fuel");
        } else {
            System.out.println("Not Enough Fuel");
        }
        System.out.println(" ");

        System.out.println(train.getVehicleType() + (": ") + (rigaDepils.getDistance() / 100 * (train.getFuelConsumption())) + (" Liters needed"));
        System.out.println(("Tank Volume: ") + (train.getTankVolume()) + (" Liters"));
        if ((rigaDepils.getDistance() / 100 * (train.getFuelConsumption()) < train.getTankVolume())) {
            System.out.println("Enough Fuel");
        } else {
            System.out.println("Not Enough Fuel");
        }
        System.out.println(" ");

        System.out.println(airplane.getVehicleType() + (": ") + (rigaDepils.getDistance() / 100 * (airplane.getFuelConsumption())) + (" Liters needed"));
        System.out.println(("Tank Volume: ") + (airplane.getTankVolume()) + (" Liters"));
        if ((rigaDepils.getDistance() / 100 * (airplane.getFuelConsumption()) < airplane.getTankVolume())) {
            System.out.println("Enough Fuel");
        } else {
            System.out.println("Not Enough Fuel");
        }
        System.out.println(" ");

        System.out.println(rigaPiter.getRouteName());
        System.out.println(" ");
        System.out.println(car.getVehicleType() + (": ") + (rigaPiter.getDistance() / 100 * (car.getFuelConsumption())) + (" Liters needed"));
        System.out.println(("Tank Volume: ") + (car.getTankVolume()) + (" Liters"));
        if ((rigaPiter.getDistance() / 100 * (car.getFuelConsumption()) < car.getTankVolume())) {
            System.out.println("Enough Fuel");
        } else {
            System.out.println("Not Enough Fuel");
        }
        System.out.println(" ");

        System.out.println(train.getVehicleType() + (": ") + (rigaPiter.getDistance() / 100 * (train.getFuelConsumption())) + (" Liters needed"));
        System.out.println(("Tank Volume: ") + (train.getTankVolume()) + (" Liters"));
        if ((rigaPiter.getDistance() / 100 * (train.getFuelConsumption()) < train.getTankVolume())) {
            System.out.println("Enough Fuel");
        } else {
            System.out.println("Not Enough Fuel");
        }
        System.out.println(" ");

        System.out.println(airplane.getVehicleType() + (": ") + (rigaPiter.getDistance() / 100 * (airplane.getFuelConsumption())) + (" Liters needed"));
        System.out.println(("Tank Volume: ") + (airplane.getTankVolume()) + (" Liters"));
        if ((rigaPiter.getDistance() / 100 * (airplane.getFuelConsumption()) < airplane.getTankVolume())) {
            System.out.println("Enough Fuel");
        } else {
            System.out.println("Not Enough Fuel");
        }
        System.out.println(" ");

        System.out.println(rigaMoscow.getRouteName());
        System.out.println(" ");
        System.out.println(car.getVehicleType() + (": ") + (rigaMoscow.getDistance() / 100 * (car.getFuelConsumption())) + (" Liters needed"));
        System.out.println(("Tank Volume: ") + (car.getTankVolume()) + (" Liters"));
        if ((rigaMoscow.getDistance() / 100 * (car.getFuelConsumption()) < car.getTankVolume())) {
            System.out.println("Enough Fuel");
        } else {
            System.out.println("Not Enough Fuel");
        }
        System.out.println(" ");

        System.out.println(train.getVehicleType() + (": ") + (rigaMoscow.getDistance() / 100 * (train.getFuelConsumption())) + (" Liters needed"));
        System.out.println(("Tank Volume: ") + (train.getTankVolume()) + (" Liters"));
        if ((rigaMoscow.getDistance() / 100 * (train.getFuelConsumption()) < train.getTankVolume())) {
            System.out.println("Enough Fuel");
        } else {
            System.out.println("Not Enough Fuel");
        }
        System.out.println(" ");

        System.out.println(airplane.getVehicleType() + (": ") + (rigaMoscow.getDistance() / 100 * (airplane.getFuelConsumption())) + (" Liters needed"));
        System.out.println(("Tank Volume: ") + (airplane.getTankVolume()) + (" Liters"));
        if ((rigaMoscow.getDistance() / 100 * (airplane.getFuelConsumption()) < airplane.getTankVolume())) {
            System.out.println("Enough Fuel");
        } else {
            System.out.println("Not Enough Fuel");
        }
    }
}
