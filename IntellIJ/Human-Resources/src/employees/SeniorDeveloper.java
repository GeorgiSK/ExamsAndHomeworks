package employees;

import enums.OperatingSystems;
import general.Project;
import interfaces.Developer;
import interfaces.Tester;

import java.util.Date;

public class SeniorDeveloper extends AbstractEmployee implements Developer, Tester {
    private Project currentDevProject;
    private Project currentTestProject;
    private OperatingSystems workstationOS;

    public SeniorDeveloper(String name, int SSN, String address, String joinDate, String lineManager) {
        super(name, SSN, address, joinDate, lineManager);
    }

    @Override
    public Project getCurrentDevProject() {
        return this.currentDevProject;
    }

    @Override
    public void setCurrentDevProject(Project project) {
        this.currentDevProject = project;
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
