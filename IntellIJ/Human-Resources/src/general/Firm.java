package general;

import enums.Statuses;
import interfaces.Employee;

import java.util.ArrayList;
import java.util.List;

public class Firm {
    private String name;
    private String address;
    private String CEOName;

    private List<Employee> employees;
    private List<Project> projects;

    public Firm(String name, String address, String CEOName) {
        this.name = name;
        this.address = address;
        this.CEOName = CEOName;
        this.employees = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCEOName() {
        return CEOName;
    }

    public void setCEOName(String CEOName) {
        this.CEOName = CEOName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }

    public Employee getEmployeeBySSN(int ssn) {
        Employee result = null;

        for (Employee employee : employees) {
            if (employee.getSSN() == ssn) {
                result = employee;
            }
        }
        return result;
    }

    public Employee getEmployeeByName(String name) {
        Employee result = null;

        for (Employee employee : employees) {
            if (employee.getName() == name) {
                result = employee;
            }
        }
        return result;
    }

    public void refreshEmployeeList() {
        for (Employee employee : employees) {
            if (employee.getStatus() == Statuses.Fired) {
                employees.remove(employee);
            }
        }
    }

    public Project getProjectByName(String name) {
        Project project = null;

        for (Project project1 : this.projects) {
            if (project1.getName().equals(name)) {
                project = project1;
            }
        }

        return project;
    }
}
