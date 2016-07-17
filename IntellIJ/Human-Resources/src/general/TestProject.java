package general;

import interfaces.Tester;

import java.util.ArrayList;
import java.util.List;

public class TestProject extends Project{

    private List<Tester> assignees;

    public TestProject(String name) {
        super(name);
        this.assignees = new ArrayList<>();
    }

    public List<Tester> getAssignees() {
        return assignees;
    }

    public void setAssignees(List<Tester> assignees) {
        this.assignees = assignees;
    }

    public void addAssignee(Tester assignee) {
        this.assignees.add(assignee);
    }
}
