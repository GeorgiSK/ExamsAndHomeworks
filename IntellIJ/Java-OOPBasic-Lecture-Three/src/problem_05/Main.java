package problem_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        List<Animal> animals = new ArrayList<>();

        while (!(input = reader.readLine()).equals("End")) {
            String[] line = input.trim().split(" ");
            String name = line[0];
            String breed = line[1];
            String operation = line[2];

            animals.add(new Animal(name, breed, operation));

            if (operation.equals("heal")) {
                AnimalClinic.healedAnimalsCount++;
                System.out.println("Patient " + AnimalClinic.patiendID + ": [" + name + " (" + breed + ")] has been healed!");
            }else {
                AnimalClinic.rehabilitedAnimalsCount++;
                System.out.println("Patient " + AnimalClinic.patiendID + ": [" + name + " (" + breed + ")] has been rehabilitated!");
            }
        }

        System.out.println("Total healed animals: " + AnimalClinic.healedAnimalsCount + "\nTotal rehabilitated animals: " + AnimalClinic.rehabilitedAnimalsCount);

        String state = reader.readLine();
        for (Animal animal : animals) {
            if (animal.state.equals(state))
                System.out.println(animal.name + " " + animal.breed);
        }
    }
}

class Animal {
    String name;
    String breed;
    String state;

    public Animal(String name, String breed, String state) {
        this.name = name;
        this.breed = breed;
        this.state = state;
        AnimalClinic.patiendID++;
    }
}

class AnimalClinic {
    static Integer patiendID = 0;
    static Integer healedAnimalsCount = 0;
    static Integer rehabilitedAnimalsCount = 0;
}
