package components.software;

import components.Component;

public abstract class SoftwareComponent implements Component {
    private String name;
    private Integer capacityConsumption;
    private Integer memoryConsumption;

    public SoftwareComponent(String name, Integer capacityConsumption, Integer memoryConsumption) {
        this.setName(name);
        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacityConsumption() {
        return capacityConsumption;
    }

    public void setCapacityConsumption(Integer capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    public Integer getMemoryConsumption() {
        return memoryConsumption;
    }

    public void setMemoryConsumption(Integer memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }
}
