package hw2;

public class TV {
    //---------------------ATTRIBUTES--------------------
    private String manufacturer;
    private int diagonal;
    private boolean plasma;
    private double price;
    private boolean leasingAvailable;

    //---------------- GETTERS/SETTERS -----------------

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public boolean isPlasma() {
        return plasma;
    }

    public void setPlasma(boolean plasma) {
        this.plasma = plasma;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isLeasingAvailable() {
        return leasingAvailable;
    }

    public void setLeasingAvailable(boolean leasingAvailable) {
        this.leasingAvailable = leasingAvailable;
    }
}
