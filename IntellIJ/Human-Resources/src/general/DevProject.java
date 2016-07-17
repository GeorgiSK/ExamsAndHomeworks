package general;

import interfaces.Developer;

import java.util.ArrayList;
import java.util.List;

public class DevProject extends Project{
    private List<Developer> assignees;

    public DevProject(String name) {
        super(name);
        this.assignees = new ArrayList<>();
    }

    public List<Developer> getAssignees() {
        return assignees;
    }

    public void setAssignees(List<Developer> assignees) {
        this.assignees = assignees;
    }

    public void addAssignee(Developer assignee) {
        this.assignees.add(assignee);
    }
}
