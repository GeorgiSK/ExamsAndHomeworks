package core;

import components.hardware.HardwareComponent;

import java.util.ArrayList;
import java.util.List;

public class Dump {
    private List<HardwareComponent> components;
    private Integer totalMemory;
    private Integer totalCapacity;

    public Dump() {
        this.components = new ArrayList<>();
        this.totalMemory = 0;
        this.totalCapacity = 0;
    }

    public List<HardwareComponent> getComponents() {
        return components;
    }

    public void dumpComponent(HardwareComponent component) {
        this.components.add(component);
        this.totalMemory += component.getUsedMemory();
        this.totalCapacity += component.getUsedCapacity();
    }

    public HardwareComponent restoreComponent (String componentName) {
        for (HardwareComponent component : components) {
            if (component.getName().equals(componentName)) {
                this.components.remove(component);
                return component;
            }
        }

        return null;
    }

    public void deleteComponent(String componentName) {
        for (HardwareComponent component : components) {
            if (component.getName().equals(componentName)) {
                this.totalMemory -= component.getUsedMemory();
                this.totalCapacity -= component.getUsedCapacity();
                this.components.remove(component);
                return;
            }
        }
    }

    public Integer getPowerHardwareCount() {
        Integer count = 0;

        for (HardwareComponent component : components) {
            if (component.getType().equals("Power")) count++;
        }
        return count;
    }

    public Integer getHeavyHardwareCount() {
        Integer count = 0;

        for (HardwareComponent component : components) {
            if (component.getType().equals("Heavy")) count++;
        }
        return count;
    }

    public Integer getTotalLightSoftwareCount() {
        Integer count = 0;

        for (HardwareComponent component : components) {
            count += component.getLightSoftwareCount();
        }

        return count;
    }

    public Integer getTotalExpressSoftwareCount() {
        Integer count = 0;

        for (HardwareComponent component : components) {
            count += component.getExpressSoftwareCount();
        }

        return count;
    }

    @Override
    public String toString() {
        return "Dump Analysis\n" +
                "Power Hardware Components: " + this.getPowerHardwareCount() + "\n" +
                "Heavy Hardware Components: " + this.getHeavyHardwareCount() + "\n" +
                "Express Software Components: " + this.getTotalExpressSoftwareCount() + "\n" +
                "Light Software Components: " + this.getTotalLightSoftwareCount() + "\n" +
                "Total Dumped Memory: " + this.totalMemory + "\n" +
                "Total Dumped Capacity: " + this.totalCapacity + "\n";
    }
}
