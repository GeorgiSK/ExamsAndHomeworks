package problem_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        Map<String, Person> people = new HashMap<>();

        while (!(input = reader.readLine()).equals("End")) {
            String[] line = input.trim().split(" ");
            Person currentPerson = people.containsKey(line[0]) ? people.get(line[0]) : new Person(line[0]);
            people.put(line[0], currentPerson);

            if (line[1].equals("company")) {
                currentPerson.company.name = line[2];
                currentPerson.company.department = line[3];
                currentPerson.company.salary = Double.parseDouble(line[4]);
            }else if(line[1].equals("pokemon")) {
                currentPerson.addPokemon(line[2], line[3]);
            }else if(line[1].equals("parents")) {
                currentPerson.addParent(line[2], line[3]);
            }else if(line[1].equals("children")) {
                currentPerson.addChild(line[2], line[3]);
            }else if(line[1].equals("car")) {
                currentPerson.car.model = line[2];
                currentPerson.car.speed = Integer.parseInt(line[3]);
            }
        }

        System.out.println(people.get(reader.readLine()).toString());

    }
}

class Person {
    String name;
    Company company = new Company();
    Car car = new Car();
    List<Parent> parents;
    List<Child> children;
    List<Pokemon> pokemons;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }


    /**
 *** Defining classes for the needed fields
 */
    class Company {
        String name = "";
        String department = "";
        Double salary = null;

        public String getSalary() {
            if (salary == null) {
                return "";
            }else {
                return " " + String.format("%.2f", this.salary) + "\n";
            }
        }

        public String getDepartment() {
            if (this.department.equals("")) {
                return "";
            }else {
                return " " + this.department;
            }
        }
    }

    class Pokemon {
        String name;
        String type;

        public Pokemon(String name, String type) {
            this.name = name;
            this.type = type;
        }
    }

    class Child {
        String name;
        String birthDay;

        public Child(String name, String birthDay) {
            this.name = name;
            this.birthDay = birthDay;
        }
    }

    class Parent {
        String name;
        String birthDay;

        public Parent(String name, String birthDay) {
            this.name = name;
            this.birthDay = birthDay;
        }
    }

    class Car {
        String model = "";
        Integer speed = null;

        public String getSpeed() {
            if (speed == null) {
                return "";
            }else {
                return " " + this.speed.toString() + "\n";
            }
        }
    }

    public void addParent(String name, String birthDay) {
        this.parents.add(new Parent(name, birthDay));
    }

    public void addChild(String name, String birthDay) {
        this.children.add(new Child(name, birthDay));
    }

    public void addPokemon(String name, String type) {
        this.pokemons.add(new Pokemon(name, type));
    }

    private String getPokemonsString() {
        String pokemons = "";

        for (Pokemon pokemon : this.pokemons) {
            pokemons += pokemon.name + " " + pokemon.type + "\n";
        }

        return pokemons;
    }

    private String getParentsString() {
        String parents = "";

        for (Parent parent : this.parents) {
            parents += parent.name + " " + parent.birthDay + "\n";
        }

        return parents;
    }

    private String getChildrenString() {
        String children = "";

        for (Child child : this.children) {
            children += child.name + " " + child.birthDay + "\n";
        }

        if (children == "") return "";
        else return "\n" + children;
    }

    @Override
    public String toString() {
        return this.name + "\nCompany:\n" + this.company.name + this.company.getDepartment() + this.company.getSalary() +
                "Car:\n" + this.car.model + this.car.getSpeed() +
                "Pokemon:\n" + this.getPokemonsString() +
                "Parents:\n" + this.getParentsString() +
                "Children:" + this.getChildrenString();
    }
}


