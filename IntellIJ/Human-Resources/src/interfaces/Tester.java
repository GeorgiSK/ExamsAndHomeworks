package interfaces;

import enums.OperatingSystems;
import general.Project;

public interface Tester {

    Project getCurrentTestProject();
    void setCurrentTestProject(Project project);
    OperatingSystems getWorkstationOS();
    void setWorkstationOS(OperatingSystems OS);
}
