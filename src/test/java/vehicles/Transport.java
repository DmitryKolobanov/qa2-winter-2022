package vehicles;

public class Transport {
    //------------------ATTRIBUTES--------------------
    private String vehicleType;
    private double tankVolume;
    private double fuelConsumption;

    //---------------- GETTERS/SETTERS -----------------

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(double tankVolume) {
        this.tankVolume = tankVolume;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
