package components.hardware;

import components.Component;
import components.software.SoftwareComponent;

import java.util.ArrayList;
import java.util.List;

public abstract class HardwareComponent implements Component {
    private String name;
    private Integer maxCapacity;
    private Integer maxMemory;
    private Integer usedMemory;
    private Integer usedCapacity;
    private List<SoftwareComponent> installedSoftware;


    public HardwareComponent(String name, Integer maxCapacity, Integer maxMemory) {
        this.setName(name);
        this.setMaxCapacity(maxCapacity);
        this.setMaxMemory(maxMemory);
        this.installedSoftware = new ArrayList<>();
        this.usedMemory = 0;
        this.usedCapacity = 0;
    }

    public List<SoftwareComponent> getInstalledSoftware() {
        return installedSoftware;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Integer getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(Integer maxMemory) {
        this.maxMemory = maxMemory;
    }

    public Integer getUsedMemory() {
        this.refreshStats();
        return usedMemory;
    }

    public Integer getUsedCapacity() {
        this.refreshStats();
        return usedCapacity;
    }

    public Integer getLightSoftwareCount() {
        Integer count = 0;

        for (SoftwareComponent softwareComponent : installedSoftware) {
            if (softwareComponent.getType().equals("LightSoftware")) {
                count++;
            }
        }
        return count;
    }

    public Integer getExpressSoftwareCount() {
        Integer count = 0;

        for (SoftwareComponent softwareComponent : installedSoftware) {
            if (softwareComponent.getType().equals("ExpressSoftware")) {
                count++;
            }
        }
        return count;
    }

    public void addSoftware(SoftwareComponent softwareComponent) {
        Integer remainingMemory = this.getMaxMemory() - this.getUsedMemory();
        Integer remainingCapacity = this.getMaxCapacity() - this.getUsedCapacity();

        if (!(remainingMemory < softwareComponent.getMemoryConsumption() || remainingCapacity < softwareComponent.getCapacityConsumption())) {
            this.installedSoftware.add(softwareComponent);
            this.usedMemory += softwareComponent.getMemoryConsumption();
            this.usedCapacity += softwareComponent.getCapacityConsumption();
        }
    }

    public void removeSoftware(SoftwareComponent softwareComponent) {
        this.installedSoftware.remove(softwareComponent);
        this.usedCapacity -= softwareComponent.getCapacityConsumption();
        this.usedMemory -= softwareComponent.getMemoryConsumption();
        softwareComponent = null;
        System.gc();
    }

    public SoftwareComponent getSoftwareComponent(String softwareName) {

        for (SoftwareComponent component : installedSoftware) {
            if (component.getName().equals(softwareName)) {
                return component;
            }
        }

        return null;
    }

    private void refreshStats() {
        Integer memory = 0;
        Integer capacity = 0;

        for (SoftwareComponent softwareComponent : installedSoftware) {
            memory += softwareComponent.getMemoryConsumption();
            capacity += softwareComponent.getCapacityConsumption();
        }

        this.usedMemory = memory;
        this.usedCapacity = capacity;
    }

}
