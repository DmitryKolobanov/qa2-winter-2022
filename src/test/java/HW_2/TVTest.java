package HW_2;

import org.junit.jupiter.api.Test;

public class TVTest {
        @Test
        public void testingTV () {
        TV testTV = new TV();

        testTV.setManufacturer("Horizont");
        testTV.setDiagonal(42);
        testTV.setPlasma(true);
        testTV.setPrice(550);
        testTV.setLeasingAvailable(true);

        System.out.println("Object: HW_2.TV");
        System.out.println(("Manufacturer: ") + (testTV.getManufacturer()));
        System.out.println(("Screen Diagonal: ") + (testTV.getDiagonal()));
        System.out.println(("Plasma Screen: ") + (testTV.isPlasma()));
        System.out.println(("Price: ") + (testTV.getPrice() + (" EUR")));
        System.out.println(("Leasing available: ") + (testTV.isLeasingAvailable()+ (" Lateko")));
        }
}
