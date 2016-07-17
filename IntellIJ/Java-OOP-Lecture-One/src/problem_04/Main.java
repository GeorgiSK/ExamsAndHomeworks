package problem_04;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //Scanner for input
        Scanner scanner = new Scanner(System.in);

        //The lists of employees and departments
        List<Employee> employees = new ArrayList<>();
        List<Department> departments = new ArrayList<>();

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().trim().split(" ");
            String department = line[3];


            if (!(departments.stream().filter(o -> o.name.equals(department)).findFirst().isPresent())) {
                Department current = new Department(department);
                current.numOfEmployees++;
                current.totalSalaries += Double.parseDouble(line[1]);
                departments.add(current);
            }else {
                departments.stream().forEach(e -> {
                    if (e.name.equals(department)){
                        e.numOfEmployees++;
                        e.totalSalaries += Double.parseDouble(line[1]);
                    }
                });
            }

            switch (line.length) {
                case 6:
                    employees.add(new Employee(line[0], Double.parseDouble(line[1]), line[2], line[3], line[4], Integer.parseInt(line[5])));
                    break;
                case 4:
                    employees.add(new Employee(line[0], Double.parseDouble(line[1]), line[2], line[3]));
                    break;
                case 5:
                    if (line[4].indexOf('@') == -1) {
                        employees.add(new Employee(line[0], Double.parseDouble(line[1]), line[2], line[3], Integer.parseInt(line[4])));
                    }else {
                        employees.add(new Employee(line[0], Double.parseDouble(line[1]), line[2], line[3], line[4]));
                    }
                    break;
            }
        }

        employees.sort((a, b) -> {
            return b.salary.compareTo(a.salary);
        });

        departments.stream().forEach(e -> e.setAverageSalary());
        departments.sort((a, b) -> {
            return b.averageSalary.compareTo(a.averageSalary);
        });


        System.out.println("Highest Average Salary: " + departments.get(0).name);

        for (Employee employee : employees) {
            if (employee.department.equals(departments.get(0).name)) {
                employee.printFields();
            }
        }
    }
}

class Employee {
    String name;
    Double salary;
    String position;
    String department;
    String email;
    int age;

    public Employee(String name, Double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, Double salary, String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }

    public Employee(String name, Double salary, String position, String department, String email) {
        this(name, salary, position, department, email, -1);
    }

    public Employee(String name, Double salary, String position, String department, int age) {
        this(name, salary, position, department, "n/a", age);
    }

    public void printFields() {
        System.out.print(this.name + " ");
        System.out.printf("%.2f", this.salary);
        System.out.print(" " + this.email + " " + this.age + "\n");
    }
}

class Department {
    String name;
    int numOfEmployees;
    Double totalSalaries;
    Double averageSalary;

    public Department(String name) {
        this.name = name;
        this.numOfEmployees = 0;
        this.totalSalaries = 0.0;
        this.averageSalary = 0.0;
    }

    public void setAverageSalary() {
        this.averageSalary = this.totalSalaries / numOfEmployees;
    }
}


