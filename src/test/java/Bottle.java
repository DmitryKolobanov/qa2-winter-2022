public class Bottle {
    //---------------------ATTRIBUTES--------------------
    private double height;
    private double diameter;
    private double volume;
    private String material;
    private boolean recyclable;

    //---------------- GETTERS/SETTERS -----------------

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isRecyclable() {
        return recyclable;
    }

    public void setRecyclable(boolean recyclable) {
        this.recyclable = recyclable;
    }
}
