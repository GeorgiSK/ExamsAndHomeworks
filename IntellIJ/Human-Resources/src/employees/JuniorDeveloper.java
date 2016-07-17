package employees;

import general.Project;
import interfaces.Developer;
import java.util.Date;

public class JuniorDeveloper extends AbstractEmployee implements Developer {
    private Project currentDevProject;

    public JuniorDeveloper(String name, int SSN, String address, String joinDate, String lineManager) {
        super(name, SSN, address, joinDate, lineManager);
    }

    @Override
    public Project getCurrentDevProject() {
        return null;
    }

    @Override
    public void setCurrentDevProject(Project project) {
        this.currentDevProject = project;
    }
}
