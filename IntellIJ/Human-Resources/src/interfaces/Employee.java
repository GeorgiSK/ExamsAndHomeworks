package interfaces;

import enums.Statuses;

public interface Employee {
    Statuses getStatus();
    void fire();
    String getName();
    void setName(String name);
    int getSSN();
    void setSSN(int SSN);
}
