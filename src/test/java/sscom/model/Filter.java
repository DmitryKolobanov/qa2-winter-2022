package sscom.model;

public class Filter {
    private String manufacturer;
    private String model;

    public Filter (String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }
}
