package components.hardware;

public class PowerHardware extends HardwareComponent{
    public PowerHardware(String name, Integer maxCapacity, Integer maxMemory) {
        super(name, maxCapacity, maxMemory);
    }

    @Override
    public void setMaxCapacity(Integer maxCapacity) {
        super.setMaxCapacity(maxCapacity - ((maxCapacity * 3) / 4));
    }

    @Override
    public void setMaxMemory(Integer maxMemory) {
        super.setMaxMemory(maxMemory + ((maxMemory * 3) / 4));
    }

    @Override
    public String getType() {
        return "Power";
    }
}
