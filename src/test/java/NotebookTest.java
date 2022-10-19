import org.junit.jupiter.api.Test;

public class NotebookTest {
    @Test
    public void testingNotebook () {

        Notebook testNotebook = new Notebook();

        testNotebook.setManufacturer("Asus");
        testNotebook.setModel("X512D");
        testNotebook.setRam(8);
        testNotebook.setHdd(256);
        testNotebook.setTouchScreen(false);

        System.out.println("Object: NOTEBOOK");
        System.out.println(("Manufacturer: ") + (testNotebook.getManufacturer()));
        System.out.println(("Model: ") + (testNotebook.getModel()));
        System.out.println(("RAM: ") + (testNotebook.getRam() + (" GB")));
        System.out.println(("HDD: ") + (testNotebook.getHdd() + (" GB")));
        System.out.println(("Touchscreen: ") + (testNotebook.isTouchScreen()));
    }
}
