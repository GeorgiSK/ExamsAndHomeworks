package problem_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carParams = reader.readLine().trim().split(" ");
        String[] truckParams = reader.readLine().trim().split(" ");
        Vehicle car = new Car(Double.parseDouble(carParams[1]), Double.parseDouble(carParams[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckParams[1]), Double.parseDouble(truckParams[2]));
        car.useConditioner();
        truck.useConditioner();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] command = reader.readLine().trim().split(" ");

            Vehicle current;

            if (command[1].equals("Car")) {
                current = car;
            }else {
                current = truck;
            }

            if (command[0].equals("Drive")) {
                current.drive(Double.parseDouble(command[2]));
            }else {
                current.refuel(Double.parseDouble(command[2]));
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}

abstract class Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption;

    public Vehicle(Double fuelQuantity, Double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void drive (Double distance) {
        this.setFuelQuantity(this.getFuelQuantity() - distance * this.getFuelConsumption());
    }

    abstract void refuel(Double liters);

    abstract void useConditioner();
}

class Car  extends Vehicle{

    public Car(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void drive(Double distance) {
        if(distance * this.getFuelConsumption() > this.getFuelQuantity()) {
            System.out.println("Car needs refueling");
            return;
        }
        super.drive(distance);

        System.out.println("Car travelled " + new DecimalFormat("###.#").format(distance) + " km");
    }

    @Override
    void refuel(Double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    @Override
    void useConditioner() {
        this.setFuelConsumption(this.getFuelConsumption() + 0.9);
    }

    @Override
    public String toString() {
        return "Car: " + String.format("%.2f", this.getFuelQuantity());
    }
}

class Truck  extends Vehicle{

    public Truck(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void drive(Double distance) {
        if(distance * this.getFuelConsumption() > this.getFuelQuantity()) {
            System.out.println("Truck needs refueling");
            return;
        }
        super.drive(distance);

        System.out.println("Truck travelled " + new DecimalFormat("###.#").format(distance) + " km");
    }

    @Override
    void refuel(Double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + liters * 0.95);
    }

    @Override
    void useConditioner() {
        this.setFuelConsumption(this.getFuelConsumption() + 1.6);
    }

    @Override
    public String toString() {
        return "Truck: " + String.format("%.2f", this.getFuelQuantity());
    }
}

