import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExamScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.nextLine();
        scanner.nextLine();
        String input;
        List<Student> students = new ArrayList<>();
        TreeSet<Integer> scores = new TreeSet<>();

        while ((input = scanner.nextLine()).charAt(0) != '-'){
            String[] studentInfo = input.split("[|]+");
            String studentName = studentInfo[1].trim();
            int studentScore = Integer.parseInt(studentInfo[2].trim());
            double studentGrade = Double.parseDouble(studentInfo[3].trim());

            if (studentGrade < 2.0 || studentGrade > 6.0) continue;
            if (studentName.length() > 50 || studentName.length() < 1) continue;
            if (studentScore < 0 || studentScore > 400) continue;
            if (containsIllegals(studentName)) continue;

            students.add(new Student(studentName, studentScore, studentGrade));
            scores.add(studentScore);
        }

        for (Integer score : scores) {
            double gradeTotal = 0.0;
            TreeSet<String> sameScoreStudents = new TreeSet<>();


            for (int i = 0; i < students.size(); i++) {
                Student currentStudent = students.get(i);

                if (currentStudent.getExamScore() == score) {
                    sameScoreStudents.add(currentStudent.getName());
                    gradeTotal += currentStudent.getGrade();
                }
            }
            double avg = gradeTotal / sameScoreStudents.size();
            //System.out.println(score + " -> " + sameScoreStudents + "; avg=" + avg);
            System.out.printf("%d -> ", score);
            System.out.print(sameScoreStudents);
            System.out.printf("; avg=%.2f\n", avg);
        }
    }

    static boolean containsIllegals(String toExamine) {
        Pattern pattern = Pattern.compile("[~#@$*+%{}<>\\[\\]|\"_^]");
        Matcher matcher = pattern.matcher(toExamine);
        return matcher.find();
    }
}

class Student {
    String name;
    int examScore;
    double grade;

    public Student(String name, int examScore, double grade) {
        this.name = name;
        this.examScore = examScore;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExamScore() {
        return examScore;
    }

    public void setExamScore(int examScore) {
        this.examScore = examScore;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
