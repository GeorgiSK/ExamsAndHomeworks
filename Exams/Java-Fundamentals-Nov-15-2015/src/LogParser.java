import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String regex = "\\{\"Project\":\\s+\\[\"(.+)\"\\],\\s+\"Type\":\\s+\\[\"(\\w+)\"\\],\\s+\"Message\":\\s+\\[\"(.+)\"\\]\\}";
        ArrayList<Project> projects = new ArrayList<>();

        while (!(input = scanner.nextLine()).equals("END")) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            boolean contains = false;
            String name = new String();
            String type = new String();
            String message = new String();
            Project existingProject = new Project(name);

            if (matcher.find()) {
                name = matcher.group(1);
                type = matcher.group(2);
                message = matcher.group(3);
            }else {
                continue;
            }

            for (int i = 0; i < projects.size(); i++) {
                if (projects.get(i).getName().equals(name)) {
                    contains = true;
                    existingProject = projects.get(i);
                }
            }

            if (!contains) {
                Project currentProject = new Project(name);
                currentProject.errors.add(new Error(type, message));
                projects.add(currentProject);
            }else {
                existingProject.errors.add(new Error(type, message));
            }
        }

        projects.sort( (a, b) -> {
            if(a.errors.size() == b.errors.size()) {
                return a.getName().compareTo(b.getName());
            }else {
                return b.errors.size() - a.errors.size();
            }
        });

        for (Project project : projects) {
            int critical = 0;
            int warning = 0;
            for (int i = 0; i < project.errors.size(); i++) {
                if (project.errors.get(i).getType().equals("Critical")) critical++;
                else warning++;
            }
            project.errors.sort((a, b) -> {
                if(a.getMessage().length() == b.getMessage().length()) {
                    return a.getMessage().compareTo(b.getMessage());
                }else {
                    return a.getMessage().length() - b.getMessage().length();
                }
            });
            System.out.println(project.getName() + ":");
            System.out.println("Total Errors: " + (critical + warning));
            System.out.println("Critical: " + critical);
            System.out.println("Warnings: " + warning);
            System.out.println("Critical Messages:");
            project.errors.stream().forEach(e -> {
                if (e.getType().equals("Critical")) {
                    System.out.println("--->" + e.getMessage());
                }
            });

            if (critical < 1) System.out.println("--->None");

            System.out.println("Warning Messages:");
            project.errors.stream().forEach(e -> {
                if (e.getType().equals("Warning")) {
                    System.out.println("--->" + e.getMessage());
                }
            });

            if (warning < 1) System.out.println("--->None");
            System.out.println();
        }

    }
}

class Project {
    private String name;
    ArrayList<Error> errors;

    public Project(String name) {
        this.name = name;
        this.errors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
}

class Error {
    String type;
    String message;

    public Error(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
