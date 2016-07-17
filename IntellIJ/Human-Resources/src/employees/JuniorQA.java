package employees;

import enums.OperatingSystems;
import general.Project;
import interfaces.Tester;

import java.util.Date;

public class JuniorQA extends  AbstractEmployee implements Tester {
    private Project currentTestProject;
    private OperatingSystems workstationOS;

    public JuniorQA(String name, int SSN, String address, String joinDate, String lineManager) {
        super(name, SSN, address, joinDate, lineManager);
    }

    @Override
    public Project getCurrentTestProject() {
        return this.currentTestProject;
    }

    @Override
    public void setCurrentTestProject(Project project) {
        this.currentTestProject = project;
    }

    @Override
    public OperatingSystems getWorkstationOS() {
        return this.workstationOS;
    }

    @Override
    public void setWorkstationOS(OperatingSystems OS) {
        this.workstationOS = OS;
    }
}
