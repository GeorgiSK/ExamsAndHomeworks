package problem_03;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> people = new TreeMap();

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().trim().split(" ");

            if (Integer.parseInt(line[1]) > 30 ) {
                people.put(line[0],Integer.parseInt(line[1]));
            }
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : people.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue());
        }
    }
}


class Person {
    String name;
    int age;

    public Person() {
        this("No name", 1);
    }

    public Person(int age) {
        this("No name", age);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}