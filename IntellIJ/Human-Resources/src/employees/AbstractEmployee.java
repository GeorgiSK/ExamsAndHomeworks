package employees;

import enums.Statuses;
import interfaces.Employee;

import java.util.Date;

public abstract class AbstractEmployee implements Employee {

    private String name;
    private int SSN;
    private String address;
    private String joinDate;
    private String lineManager;
    private Statuses status;

    public AbstractEmployee(String name, int SSN, String address, String joinDate, String lineManager) {
        this.name = name;
        this.SSN = SSN;
        this.address = address;
        this.joinDate = joinDate;
        this.lineManager = lineManager;
        this.status = Statuses.Working;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getLineManager() {
        return lineManager;
    }

    public void setLineManager(String lineManager) {
        this.lineManager = lineManager;
    }

    @Override
    public Statuses getStatus() {
        return this.status;
    }

    @Override
    public void fire() {
        this.status = Statuses.Fired;
    }
}
