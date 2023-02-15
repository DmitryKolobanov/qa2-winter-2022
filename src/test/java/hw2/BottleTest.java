package hw2;

import org.junit.jupiter.api.Test;

public class BottleTest {
    @Test
    public void testingBottle() {
        Bottle testBottle = new Bottle();

        testBottle.setDiameter(80.00);
        testBottle.setHeight(200.00);
        testBottle.setMaterial("Plastic");
        testBottle.setVolume(0.50);
        testBottle.setRecyclable(true);

        System.out.println("Object: BOTTLE");
        System.out.println(("Diameter: ")+(testBottle.getDiameter()));
        System.out.println(("Height: ")+(testBottle.getHeight()));
        System.out.println(("Material: ")+(testBottle.getMaterial()));
        System.out.println(("Volume: ")+(testBottle.getVolume()));
        System.out.println(("Recycleable: ")+(testBottle.isRecyclable()));
    }
}
