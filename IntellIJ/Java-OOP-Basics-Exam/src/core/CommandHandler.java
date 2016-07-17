package core;

import components.hardware.HeavyHardware;
import components.hardware.PowerHardware;
import components.software.ExpressSoftware;
import components.software.LightSoftware;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandHandler {
    private System system;

    public CommandHandler(System system) {
        this.system = system;
    }

    public void registerPowerHardware(String name, Integer capacity, Integer memory) {
        this.system.addHardware(new PowerHardware(name, capacity, memory));
    }

    public void registerHeavyHardware(String name, Integer capacity, Integer memory) {
        this.system.addHardware(new HeavyHardware(name, capacity, memory));
    }

    public void registerExpressSoftware(String hardwareComponentName, String name, Integer capacity, Integer memory) {
        this.system.addSoftware(hardwareComponentName, new ExpressSoftware(name, capacity, memory));
    }

    public void registerLightSoftware(String hardwareComponentName, String name, Integer capacity, Integer memory) {
        this.system.addSoftware(hardwareComponentName, new LightSoftware(name, capacity, memory));
    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        this.system.removeSoftware(hardwareComponentName, softwareComponentName);
    }

    public void analyze() {
        java.lang.System.out.println(this.system.toString());
    }

    public String systemSplit() {
        return this.system.split();
    }

    public void dump(String hardwareComponentName) {
        this.system.dump(hardwareComponentName);
    }

    public void restore(String hardwareComponentName) {
        this.system.restoreFromDump(hardwareComponentName);
    }

    public void destroy(String hardwareComponentName) {
        this.system.removeComponentFromDump(hardwareComponentName);
    }

    public void dumpAnalyze() {
        java.lang.System.out.println(this.system.getDumpAnalysisData());
    }

    public void handleCommand(String command) {
        Pattern pattern;
        Matcher matcher;

        if (command.contains("RegisterPowerHardware")) {
            pattern = Pattern.compile("([A-Za-z\\d]+), (\\d+), (\\d+)");
            matcher = pattern.matcher(command);
            matcher.find();
            this.registerPowerHardware(matcher.group(1),Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
        }else if (command.contains("RegisterHeavyHardware")) {
            pattern = Pattern.compile("([A-Za-z\\d]+), (\\d+), (\\d+)");
            matcher = pattern.matcher(command);
            matcher.find();
            this.registerHeavyHardware(matcher.group(1),Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
        }else if (command.contains("RegisterExpressSoftware")) {
            pattern = Pattern.compile("\\(([A-Za-z\\d]+), ([A-Za-z\\d]+), (\\d+), (\\d+)\\)");
            matcher = pattern.matcher(command);
            matcher.find();
            this.registerExpressSoftware(matcher.group(1), matcher.group(2), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)));
        }else if (command.contains("RegisterLightSoftware")) {
            pattern = Pattern.compile("\\(([A-Za-z\\d]+), ([A-Za-z\\d]+), (\\d+), (\\d+)\\)");
            matcher = pattern.matcher(command);
            matcher.find();
            this.registerLightSoftware(matcher.group(1), matcher.group(2), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)));
        }else if (command.contains("ReleaseSoftwareComponent")) {
            pattern = Pattern.compile("\\(([A-Za-z\\d]+), ([A-Za-z\\d]+)\\)");
            matcher = pattern.matcher(command);
            matcher.find();
            this.releaseSoftwareComponent(matcher.group(1), matcher.group(2));
        }else if (command.contains("Restore")) {
            pattern = Pattern.compile("\\(([A-Za-z\\d]+)\\)");
            matcher = pattern.matcher(command);
            matcher.find();
            this.restore(matcher.group(1));
        }else if (command.contains("Destroy")) {
            pattern = Pattern.compile("\\(([A-Za-z\\d]+)\\)");
            matcher = pattern.matcher(command);
            matcher.find();
            this.destroy(matcher.group(1));
        }else if (command.contains("DumpAnalyze")) {
            this.dumpAnalyze();
        }else if (command.contains("Analyze")) {
            this.analyze();
        }else {
            pattern = Pattern.compile("\\(([A-Za-z\\d]+)\\)");
            matcher = pattern.matcher(command);
            matcher.find();
            this.dump(matcher.group(1));
        }
    }
}
