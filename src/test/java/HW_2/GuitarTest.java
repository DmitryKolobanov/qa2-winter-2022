package HW_2;

import org.junit.jupiter.api.Test;

public class GuitarTest {
    @Test
    public void testingGuitar () {

        Guitar testGuitar = new Guitar();

        testGuitar.setNanufacturer("Fender");
        testGuitar.setType("Acoustic");
        testGuitar.setBodyMaterial("Pine");
        testGuitar.setStringCount(6);
        testGuitar.setLeftHanded(false);

        System.out.println("Object: GUITAR");
        System.out.println(("Manufacturer: ")+(testGuitar.getNanufacturer()));
        System.out.println(("Type: ")+(testGuitar.getType()));
        System.out.println(("Material: ")+(testGuitar.getBodyMaterial()));
        System.out.println(("String count: ")+(testGuitar.getStringCount()));
        System.out.println(("Left handed: ")+(testGuitar.isLeftHanded()));
    }
}
