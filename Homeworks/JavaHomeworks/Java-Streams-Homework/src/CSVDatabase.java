import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CSVDatabase {
    public static void main(String[] args) {
        HashMap<Integer, String> studentById = new HashMap<>();
        HashMap<Integer, ArrayList<String>> studentProfileById = new HashMap<>();
        HashMap<Integer, HashMap<String, ArrayList<Float>>> subjectsAndGradesById = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        String input= scanner.nextLine();

        while(!input.equals("exit")) {
            String[] parameters = input.split(" ");
            String name;
            int id = 0;

            if(parameters[0].equals("Search-by-full-name")) {
                name = parameters[1] + " " + parameters[2];
                searchByFullName(name);
            }else if (parameters[0].equals("Search-by-id")) {
                id = Integer.parseInt(parameters[1]);
                searchById(id);
            }else if (parameters[0].equals("Delete-by-id")) {
                id = Integer.parseInt(parameters[1]);
                deleteById(id);
            }else if (parameters[0].equals("Update-by-id")) {
                id = Integer.parseInt(parameters[1]);
                updateById(id);
            }else if(parameters[0].equals("Insert-student")) {
                name = parameters[1] + " " + parameters[2];
                int age = Integer.parseInt(parameters[3]);
                insertStudent(name, age, parameters[4]);
            }else if(parameters[0].equals("Insert-grade-by-id")) {
                id = Integer.parseInt(parameters[1]);
                String subject = parameters[2];
                float grade = Float.parseFloat(parameters[3]);
                insertGradeById(id, subject, grade);
            }
            input = scanner.nextLine();
        }
    }

    static void searchByFullName(String fullName) {

        try(BufferedReader studentsFile = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            int id = 0;

            while((line = studentsFile.readLine()) != null) {
                String[] elements = line.split(",");

                if ((elements[1] + " " + elements[2]).equals(fullName)) {
                    int age = Integer.parseInt(elements[3]);
                    String town = elements[4];
                    System.out.println(fullName + " (" + "age: " + age + ", town: " + town + ")");
                    id = Integer.parseInt(elements[0]);
                    break;
                }
            }

            try(BufferedReader gradesFile = new BufferedReader(new FileReader("grades.txt"))) {
                while ((line = gradesFile.readLine()) != null) {
                    String[] elements = line.split(",");

                    if (Integer.parseInt(elements[0]) == id) {
                        for (int i = 1; i < elements.length; i++) {
                            System.out.println("#" + elements[i]);
                        }
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void searchById(int id) {
        try(BufferedReader studentsFile = new BufferedReader(new FileReader("students.txt"))) {
            String line;

            while((line = studentsFile.readLine()) != null) {
                String[] elements = line.split(",");

                if(Integer.parseInt(elements[0]) == id) {
                    int age = Integer.parseInt(elements[3]);
                    String town = elements[4];
                    String name = (elements[1] + " " + elements[2]);
                    System.out.println(name + " (" + "age: " + age + ", town: " + town + ")");
                    break;
                }
            }

            try(BufferedReader gradesFile = new BufferedReader(new FileReader("grades.txt"))) {
                while ((line = gradesFile.readLine()) != null) {
                    String[] elements = line.split(",");

                    if (Integer.parseInt(elements[0]) == id) {
                        for (int i = 1; i < elements.length; i++) {
                            System.out.println("#" + elements[i]);
                        }
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deleteById(int id) {

    }

    static void updateById (int id) {

    }

    static void insertStudent(String fullName, int age, String town) {

    }

    static void insertGradeById(int id, String subject, float grade) {

    }
}
