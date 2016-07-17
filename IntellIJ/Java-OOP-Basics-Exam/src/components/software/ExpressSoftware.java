package components.software;

public class ExpressSoftware extends SoftwareComponent{
    public ExpressSoftware(String name, Integer capacityConsumption, Integer memoryConsumption) {
        super(name, capacityConsumption, memoryConsumption);
    }

    @Override
    public void setMemoryConsumption(Integer memoryConsumption) {
        super.setMemoryConsumption(memoryConsumption * 2);
    }

    @Override
    public String getType() {
        return "ExpressSoftware";
    }
}
