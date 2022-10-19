import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void testingCar(){
        Car testCar = new Car();

        testCar.setManufacturer("Audi");
        testCar.setModel("Coupe");
        testCar.setEngineVolume(3.00);
        testCar.setWheelCount(4);
        testCar.setFuelType("Diesel");

        System.out.println("Object: CAR");
        System.out.println(("Manufacturer: ")+(testCar.getManufacturer()));
        System.out.println(("Model: ")+(testCar.getModel()));
        System.out.println(("Engine Volume: ")+(testCar.getEngineVolume()));
        System.out.println(("Wheels: ")+(testCar.getWheelCount()));
        System.out.println(("Fuel: ")+(testCar.getFuelType()));

    }
}
