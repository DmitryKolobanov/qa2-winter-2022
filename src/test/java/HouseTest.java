import org.junit.jupiter.api.Test;

public class HouseTest {
    @Test
    public void testingHouse () {

        House testHouse = new House();

        testHouse.setWallMaterial("Stone");
        testHouse.setFloorCount(9);
        testHouse.setElevator(true);
        testHouse.setParking(true);
        testHouse.setSolarPanels(false);

        System.out.println("Object: HOUSE");
        System.out.println(("Wall material: ")+(testHouse.getWallMaterial()));
        System.out.println(("Floors: ")+(testHouse.getFloorCount()));
        System.out.println(("Elevator: ")+(testHouse.isElevator()));
        System.out.println(("Parking: ")+(testHouse.isParking()));
        System.out.println(("Solar panels: ")+(testHouse.isSolarPanels()));
    }
}

