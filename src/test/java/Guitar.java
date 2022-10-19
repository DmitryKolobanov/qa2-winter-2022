public class Guitar {
    //---------------------ATTRIBUTES--------------------
    private String nanufacturer;
    private String type;
    private String bodyMaterial;
    private int stringCount;
    private boolean leftHanded;

    //---------------- GETTERS/SETTERS -----------------

    public String getNanufacturer() {
        return nanufacturer;
    }

    public void setNanufacturer(String nanufacturer) {
        this.nanufacturer = nanufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBodyMaterial() {
        return bodyMaterial;
    }

    public void setBodyMaterial(String bodyMaterial) {
        this.bodyMaterial = bodyMaterial;
    }

    public int getStringCount() {
        return stringCount;
    }

    public void setStringCount(int stringCount) {
        this.stringCount = stringCount;
    }

    public boolean isLeftHanded() {
        return leftHanded;
    }

    public void setLeftHanded(boolean leftHanded) {
        this.leftHanded = leftHanded;
    }
}
