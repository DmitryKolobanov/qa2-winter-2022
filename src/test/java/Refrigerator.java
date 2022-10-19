public class Refrigerator {
    //---------------------ATTRIBUTES--------------------
    private String manufacturer;
    private int cameraCount;
    private double minTemp;
    private double maxTemp;
    private boolean beerIncluded;


    //---------------- GETTERS/SETTERS -----------------

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCameraCount() {
        return cameraCount;
    }

    public void setCameraCount(int cameraCount) {
        this.cameraCount = cameraCount;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public boolean isBeerIncluded() {
        return beerIncluded;
    }

    public void setBeerIncluded(boolean beerIncluded) {
        this.beerIncluded = beerIncluded;
    }
}
