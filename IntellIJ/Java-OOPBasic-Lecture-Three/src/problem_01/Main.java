package problem_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (!(input = reader.readLine()).equals("End")) {
            new Student(input);
        }

        System.out.println(Student.studentsCount);

    }
}

class Student {
    String name;
    static Integer studentsCount = 0;

    public Student(String name) {
        this.name = name;
        studentsCount++;
    }
}