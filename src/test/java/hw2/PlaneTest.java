package hw2;

import org.junit.jupiter.api.Test;

public class PlaneTest {
    @Test
    public void testingPhone () {

        Plane testPlane = new Plane();

        testPlane.setManufacturer("Tupolev");
        testPlane.setEngineCount(3);
        testPlane.setCrewCount(4);
        testPlane.setMaxLoad(98000);
        testPlane.setCargo(false);

        System.out.println("Object: PLANE");
        System.out.println(("Manufacturer: ") + (testPlane.getManufacturer()));
        System.out.println(("Engine Count: ") + (testPlane.getEngineCount()));
        System.out.println(("Cockpit Crew: ") + (testPlane.getCrewCount()));
        System.out.println(("Max weight: ") + (testPlane.getMaxLoad() + (" kg")));
        System.out.println(("Cargo: ") + (testPlane.isCargo()));
    }
}
