package problem_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (!(input = reader.readLine()).equals("End")) {
            new Student(input);
        }

        System.out.println(StudentGroup.students.size());
    }
}

class Student {
    String name;

    public Student(String name) {
        this.name = name;

        StudentGroup.addStudent(this);
    }
}

class StudentGroup {
    static HashSet<Student> students = new HashSet<>();

    public static void addStudent(Student student) {
        boolean exists = false;
        for (Student student1 : students) {
            if (student1.name.equals(student.name)) exists = true;
        }

        if (!exists) {
            students.add(student);
        }
    }
}
