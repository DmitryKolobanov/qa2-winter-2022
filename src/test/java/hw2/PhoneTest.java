package hw2;

import org.junit.jupiter.api.Test;

public class PhoneTest {
    @Test
    public void testingPhone () {

        Phone testPhone = new Phone();

        testPhone.setManufacturer("Apple");
        testPhone.setScreenDiagonal(6.7);
        testPhone.setCameraResolution(12);
        testPhone.setWaterproof(true);
        testPhone.setTwoSIM(false);

        System.out.println("Object: PHONE");
        System.out.println(("Manufacturer: ") + (testPhone.getManufacturer()));
        System.out.println(("Screen Diagonal: ") + (testPhone.getScreenDiagonal()));
        System.out.println(("Camera Resolution: ") + (testPhone.getCameraResolution() + (" MP")));
        System.out.println(("Waterproof: ") + (testPhone.isWaterproof()));
        System.out.println(("Two SIM: ") + (testPhone.isTwoSIM()));
    }
}
