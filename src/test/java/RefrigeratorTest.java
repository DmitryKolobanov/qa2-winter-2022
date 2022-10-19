import org.junit.jupiter.api.Test;

public class RefrigeratorTest {
    @Test
    public void testingRefrigerator () {

        Refrigerator testRefrigerator = new Refrigerator();

        testRefrigerator.setManufacturer("Saratov");
        testRefrigerator.setCameraCount(2);
        testRefrigerator.setMinTemp(-20);
        testRefrigerator.setMaxTemp(5);
        testRefrigerator.setBeerIncluded(true);

        System.out.println("Object: REFRIGERATOR");
        System.out.println(("Manufacturer: ") + (testRefrigerator.getManufacturer()));
        System.out.println(("Camera Count: ") + (testRefrigerator.getCameraCount()));
        System.out.println(("Temp. MIN: ") + (testRefrigerator.getMinTemp()+ (" C")));
        System.out.println(("Temp. MAX: ") + (testRefrigerator.getMaxTemp() + (" C")));
        System.out.println(("Beer included: ") + (testRefrigerator.isBeerIncluded()));
    }
}
