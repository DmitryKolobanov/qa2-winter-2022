public class Phone {
    //---------------------ATTRIBUTES--------------------
    private String manufacturer;
    private double screenDiagonal;
    private double cameraResolution;
    private boolean waterproof;
    private boolean twoSIM;

    //---------------- GETTERS/SETTERS -----------------


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(double screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    public double getCameraResolution() {
        return cameraResolution;
    }

    public void setCameraResolution(double cameraResolution) {
        this.cameraResolution = cameraResolution;
    }

    public boolean isWaterproof() {
        return waterproof;
    }

    public void setWaterproof(boolean waterproof) {
        this.waterproof = waterproof;
    }

    public boolean isTwoSIM() {
        return twoSIM;
    }

    public void setTwoSIM(boolean twoSIM) {
        this.twoSIM = twoSIM;
    }
}
