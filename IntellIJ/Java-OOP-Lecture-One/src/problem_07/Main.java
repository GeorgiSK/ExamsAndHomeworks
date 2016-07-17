package problem_07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        //Get Engines
        for (int i = 0; i < n; i++) {
            //Input line
            String[] line = scanner.nextLine().trim().split("[\\s]+");

            //Determine whether the optional fields are specified
            if (line.length == 4) {
                try {
                    engines.add(new Engine(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), line[3]));
                }catch (Exception e) {

                }
            }else if (line.length == 3) {
                //If the third parameter contains a letter it must be the efficiency parameter
                if (line[2].matches("[A-z]+")) {
                    try {
                        engines.add(new Engine(line[0], Integer.parseInt(line[1]), line[2]));
                    }catch (Exception e) {

                    }
                }else {
                    //otherwise it is the displacement parameter
                    try {
                        engines.add(new Engine(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2])));
                    }catch (Exception e) {

                    }
                }
            }else if (line.length == 2) {
                try {
                    engines.add(new Engine(line[0], Integer.parseInt(line[1])));
                }catch (Exception e) {

                }
            }
        }

        //Get Cars
        int m = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < m; i++) {
            //Input line
            String[] line = scanner.nextLine().trim().split("[\\s]+");
            Engine currentEngine = null;

            //Get the engine
            for (Engine engine : engines) {
                if (engine.getModel().equals(line[1])) {
                    currentEngine = engine;
                }
            }

            //Determine whether the optional fields are specified
            if (line.length == 4) {
                try {
                    cars.add(new Car(line[0], currentEngine, Integer.parseInt(line[2]), line[3]));
                }catch (Exception e) {

                }
            }else if (line.length == 3) {
                //If the third parameter contains a letter it must be the efficiency parameter
                if (line[2].matches("[A-Za-z]+")) {
                    try {
                        cars.add(new Car(line[0], currentEngine, line[2]));
                    }catch (Exception e) {

                    }
                }else {
                    //otherwise it is the displacement parameter
                    try {
                        cars.add(new Car(line[0], currentEngine, Integer.parseInt(line[2])));
                    }catch (Exception e) {

                    }
                }
            }else if (line.length == 2) {
                try {
                    cars.add(new Car(line[0], currentEngine));
                }catch (Exception e) {

                }
            }
        }

        //Print results on the screen
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}

class Car {
    private String model;
    private Engine engine;
    private Integer weight;
    private String color;

    public Car(String model, Engine engine, Integer weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this(model, engine, null, null);
    }

    public Car(String model, Engine engine, Integer weight) {
        this(model, engine, weight, null);
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, null, color);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String weight = null;
        if (this.weight == null)
            weight = "n/a";
        else
            weight = this.weight.toString();
        if (this.color == null) this.color = "n/a";

        return this.model + ":\n" + this.engine.toString() + "  Weight: " + weight + "\n" + "  Color: " + this.color;
    }
}

class Engine {
    private String model;
    private Integer power;
    private Integer displacement;
    private String efficiency;

    public Engine(String model, Integer power, Integer displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, Integer power) {
        this(model, power, null, null);
    }

    public Engine(String model, Integer power, Integer displacement) {
        this(model, power, displacement, null);
    }

    public Engine(String model, Integer power, String efficiency) {
        this(model, power, null, efficiency);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Integer displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        String displacement;
        if (this.displacement == null)
            displacement = "n/a";
        else
            displacement = this.displacement.toString();
        if (this.efficiency == null) efficiency = "n/a";

        return "  " + this.model + ":\n" + "    Power: " + this.power + "\n    Displacement: " + displacement + "\n    Efficiency: " + this.efficiency + "\n";
    }

    
}
