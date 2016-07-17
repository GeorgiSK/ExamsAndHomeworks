import java.io.*;

public class SaveACustomObjectInAFile {
    //Declaring constant variables for the path to the files
    private static final String FILE_PATH = "course.save";

    public static void main(String[] args) {
        //Instantiating new files for reference
        File file = new File(FILE_PATH);

        Course javaFundamentals = new Course(400, "Java Fundamentals");

        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
            //Here we take the object and we write it to the file
            output.writeObject(javaFundamentals);

            try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
                //Here we read the object from the file, cast it to a Course and save it into a Course var
                Course course = (Course)input.readObject();

                //Here we use the methods of the Course class to print info on the console
                System.out.println(course.getName());
                System.out.println(course.getNumOfStudents());
            }catch (Exception ex) {
                //If problem occurs during the reading of the file this message gets printed
                System.out.println("There was a problem while reading from the file!");
            }
        }catch (Exception ex) {
            //If problem occurs during the writing to the file this message gets printed
            System.out.println("A problem occurred while writing to the file!");
        }
    }
}
