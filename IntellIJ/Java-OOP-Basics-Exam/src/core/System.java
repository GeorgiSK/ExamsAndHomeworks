package core;

import components.hardware.HardwareComponent;
import components.software.SoftwareComponent;

import java.util.ArrayList;
import java.util.List;

public class System {
    private List<HardwareComponent> hardwareComponents;
    private Integer totalPhysicalMemory;
    private Integer totalMemoryInUse;
    private Integer totalCapacity;
    private Integer totalCapacityInUse;
    private Dump dump;

    public System() {
        this.totalPhysicalMemory = 0;
        this.totalMemoryInUse = 0;
        this.hardwareComponents = new ArrayList<>();
        this.totalCapacity = 0;
        this.totalCapacityInUse = 0;
        this.dump = new Dump();
    }

    public Integer getTotalPhysicalMemory() {
        return totalPhysicalMemory;
    }

    public Integer getTotalMemoryInUse() {
        return totalMemoryInUse;
    }

    public Integer getTotalCapacity() {
        return totalCapacity;
    }

    public Integer getTotalCapacityInUse() {
        return totalCapacityInUse;
    }

    public Integer getSoftwareComponentsCount() {
        Integer count = 0;
        for (HardwareComponent hardwareComponent : hardwareComponents) {
            count += hardwareComponent.getInstalledSoftware().size();
        }

        return count;
    }
    public HardwareComponent getHardwareComponent(String hardwareComponentName) {
        for (HardwareComponent hardwareComponent : hardwareComponents) {
            if (hardwareComponent.getName().equals(hardwareComponentName)) {
                return hardwareComponent;
            }
        }
        return null;
    }

    public void addHardware(HardwareComponent hardwareComponent) {
        this.hardwareComponents.add(hardwareComponent);
        this.refreshStats();
    }

    public void removeHardwareComponent(String hardwareName) {
        HardwareComponent component = this.getHardwareComponent(hardwareName);

        if (component != null) {
            this.hardwareComponents.remove(component);
            this.refreshStats();
        }
    }

    public void addSoftware(String hardwareComponentName, SoftwareComponent softwareComponent) {
        HardwareComponent component = null;

        for (HardwareComponent hardwareComponent : hardwareComponents) {
            if (hardwareComponent.getName().equals(hardwareComponentName)) component = hardwareComponent;
        }

        if (component != null) {
            component.addSoftware(softwareComponent);
            this.refreshStats();
        }
    }

    public void removeSoftware(String hardwareComponentName, String softwareName) {
        HardwareComponent hardware = null;
        SoftwareComponent software = null;

        for (HardwareComponent hardwareComponent : hardwareComponents) {
            if (hardwareComponent.getName().equals(hardwareComponentName)) {
                hardware = hardwareComponent;
                software = hardwareComponent.getSoftwareComponent(softwareName);
            }
        }

        if (hardware != null && software != null) {
            hardware.removeSoftware(software);
            this.refreshStats();
        }
    }

    public String split() {
        String result = "";

        //this.hardwareComponents.sort((a, b) -> a.getName().equals(b.getName()));

        for (HardwareComponent hardwareComponent : hardwareComponents) {
            result += "Hardware Component - " + hardwareComponent.getName() + "\n" +
                    "Express Software Components - " + hardwareComponent.getExpressSoftwareCount() + "\n" +
                    "Light Software Components - " + hardwareComponent.getLightSoftwareCount() + "\n" +
                    "Memory Usage: " + hardwareComponent.getUsedMemory() + " / " + hardwareComponent.getMaxMemory() + "\n" +
                    "Capacity Usage: " + hardwareComponent.getUsedCapacity() + " / " + hardwareComponent.getMaxCapacity() + "\n" +
                    "Type: " + hardwareComponent.getType() + "\n" +
                    "Software Components: ";

            if (!(hardwareComponent.getInstalledSoftware().size() == 0)) {
                result += hardwareComponent.getInstalledSoftware().get(0).getName();

                for (int i = 1; i < hardwareComponent.getInstalledSoftware().size(); i++) {
                    result += ", " + hardwareComponent.getInstalledSoftware().get(i).getName();
                }
            }else result += "None";

            result += "\n";
        }

        return result;
    }

    private void refreshStats() {
        this.totalMemoryInUse = 0;
        this.totalCapacityInUse = 0;
        this.totalCapacity = 0;
        this.totalPhysicalMemory = 0;
        for (HardwareComponent hardwareComponent : hardwareComponents) {
            this.totalMemoryInUse += hardwareComponent.getUsedMemory();
            this.totalCapacityInUse += hardwareComponent.getUsedCapacity();
            this.totalPhysicalMemory += hardwareComponent.getMaxMemory();
            this.totalCapacity += hardwareComponent.getMaxCapacity();
        }
    }

    public void dump(String hardwareComponentName) {
        HardwareComponent componentToDump = this.getHardwareComponent(hardwareComponentName);

        if (componentToDump != null) {
            this.dump.dumpComponent(componentToDump);
            this.removeHardwareComponent(hardwareComponentName);
        }
    }

    public void restoreFromDump (String hardwareComponentName) {
        HardwareComponent restoredComponent = dump.restoreComponent(hardwareComponentName);

        if (restoredComponent != null) {
            this.addHardware(restoredComponent);
        }
    }

    public void removeComponentFromDump(String hardwareComponentName) {
        this.dump.deleteComponent(hardwareComponentName);
    }

    public String getDumpAnalysisData() {
        return this.dump.toString();
    }

    @Override
    public String toString() {
        return "System Analysis\n" +
                "Hardware Components: " + this.hardwareComponents.size() + "\n" +
                "Software Components: " + this.getSoftwareComponentsCount() + "\n" +
                "Total Operational Memory: " + this.getTotalMemoryInUse() + " / " + this.getTotalPhysicalMemory() + "\n" +
                "Total Capacity Taken: " + this.getTotalCapacityInUse() + " / " + this.getTotalCapacity();
    }
}
