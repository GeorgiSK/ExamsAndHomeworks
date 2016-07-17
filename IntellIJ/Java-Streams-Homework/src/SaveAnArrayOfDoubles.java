import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveAnArrayOfDoubles {
    //Declaring constant variables for the path to the files
    private static final String FILE_PATH = "doubles.list";

    public static void main(String[] args) {
        //Instantiating new files for reference
        File file = new File(FILE_PATH);
        //Creating the list with doubles
        List<Double> inputList = new ArrayList<>();

        //Filling out the list
        inputList.add(17.545345);
        inputList.add(45.345345);
        inputList.add(123123.1231233);
        inputList.add(3456.234656);
        inputList.add(6765.244465);

        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {
            //Here we take the info of the ArrayList and we write it to the file as an object
            output.writeObject(inputList);

            try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
                //Here we read the object of the file and print it on the console
                System.out.println(input.readObject());
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
