import java.io.Serializable;

public class Course implements Serializable{
    String name;
    int numOfStudents;

    public Course(int numOfStudents, String name) {
        this.numOfStudents = numOfStudents;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getNumOfStudents() {
        return this.numOfStudents;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void increaseNumOfStudents(int n) {
        this.numOfStudents += n;
    }

    public void decreaseNumOfStudents(int n) {
        this.numOfStudents -= n;
    }
}
