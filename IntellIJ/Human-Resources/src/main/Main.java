package main;

import general.*;
import interfaces.*;
import employees.*;
import enums.*;

import java.util.Scanner;

public class Main {
    static Firm firm;

    public static void main(String[] args) {
        //Create scanner for user input
        Scanner scanner = new Scanner(System.in);
        //Variable for user input
        String input;

        //Variables for the Firm creation
        String name;
        String address;
        String CEOName;

        //Get User input
        System.out.print("Enter Firm Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Firm Address: ");
        address = scanner.nextLine();
        System.out.print("Enter CEO: ");
        CEOName = scanner.nextLine();

        //Create the firm
        firm = new Firm(name, address, CEOName);

        //Instructions message
        System.out.println("Enter commands predefined in the README file or 'exit' to close the program");

        //Program loop
        while(!(input = scanner.nextLine()).equals("exit")) {
            handleInput(input);

            //Update Firm properties
            firm.refreshEmployeeList();
        }
    }

    static void editFirmProperties(String name, String address, String CEO) {
        firm.setName(name);
        firm.setAddress(address);
        firm.setCEOName(CEO);
    }

    static void hireEmployee(Employee employee) {
        firm.addEmployee(employee);
    }

    static void fireEmployee(Employee employee) {
        employee.fire();
    }

    static void printFirmInfo() {
        System.out.println(firm.getName());
        System.out.println(firm.getAddress());
        System.out.println(firm.getCEOName());
    }

    static void printEmployeeInfo(Employee employee) {
        System.out.println(employee.getName());
        System.out.println(employee.getSSN());
        System.out.println(((AbstractEmployee) employee).getAddress());
        System.out.println(((AbstractEmployee) employee).getJoinDate());
        System.out.println(((AbstractEmployee) employee).getLineManager());

        if (employee instanceof SeniorDeveloper) {
            System.out.println(((SeniorDeveloper) employee).getCurrentDevProject());
            System.out.println(((SeniorDeveloper) employee).getCurrentTestProject());
            System.out.println(((SeniorDeveloper) employee).getWorkstationOS());
        }else if (employee instanceof JuniorDeveloper){
            System.out.println(((JuniorDeveloper) employee).getCurrentDevProject());
        }else if (employee instanceof JuniorQA) {
            System.out.println(((JuniorQA) employee).getCurrentTestProject());
            System.out.println(((JuniorQA) employee).getWorkstationOS());
        }
    }

    static void getAssigneesOnProject(Project project) {

    }

    static void assignToProject(String employeeName, String projectName) {
        Project project = firm.getProjectByName(projectName);
        Employee employee = firm.getEmployeeByName(employeeName);
    }

    static void createProject(String name, String type) {
        Project project;
        if (type.equals("DevProject")) {
            project = new DevProject(name);
        }else {
            project = new TestProject(name);
        }

        firm.addProject(project);
    }

    static void handleInput(String input) {
        String[] data = input.split(" -> ");
        String[] params;

        switch (data[0]) {
            case "editFirmDetails":
                params = data[1].trim().split(", ");
                editFirmProperties(params[0], params[1], params[2]);
                break;
            case "createProject":
                params = data[1].trim().split(", ");

                createProject(params[0], params[1]);
                break;
            case "printFirmProperties":
                printFirmInfo();
                break;
            case "addEmployee":
                params = data[1].trim().split(", ");
                Employee employee;

                if (params[5].equals("SeniorDeveloper")) {
                    employee = new SeniorDeveloper(params[0], Integer.parseInt(params[1]), params[2], params[3], params[4]);
                }else if (params[5].equals("JuniorDeveloper")) {
                    employee = new JuniorDeveloper(params[0], Integer.parseInt(params[1]), params[2], params[3], params[4]);
                }else {
                    employee = new JuniorQA(params[0], Integer.parseInt(params[1]), params[2], params[3], params[4]);
                }

                hireEmployee(employee);

                break;
            case "assignToProject":
                params = data[1].trim().split(", ");

                assignToProject(params[0], params[1]);
                break;
            case "getEmployeeByName":
                params = data[1].trim().split(", ");
                printEmployeeInfo(firm.getEmployeeByName(params[1]));
                break;
            case "getEmployeeBySSN":
                params = data[1].trim().split(", ");
                printEmployeeInfo(firm.getEmployeeBySSN(Integer.parseInt(params[1])));
                break;
            case "fireEmployee":
                params = data[1].trim().split(", ");
                fireEmployee(firm.getEmployeeByName(params[1]));
                break;
            case "editEmployeeDetails":
                break;
            case "getAssigneesOnProject":
                break;
            default:
                System.out.println("Command is not recognized");
        }
    }
}
