import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SumLines {
    //Declaring a constant variable for the path to the file
    private static final String FILE_PATH = "lines.txt";
    public static void main(String[] args) {
        //Instantiating a new file for reference
        File file = new File(FILE_PATH);

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            //Getting input line by line
            String line = reader.readLine();

            while (line != null) {
                int sum = 0;
                //Converting the input to a char array
                char[] chars = line.toCharArray();

                //Iterating through the array while composing the sum of all the chars
                for (char aChar : chars) {
                    sum += aChar;
                }
                //Printing the sum on the console
                System.out.println(sum);
                //Getting the next line of the file
                line = reader.readLine();
            }
        }catch(Exception ex) {
            //If problem occurs during the reading of the file this message gets printed
            System.out.println("There was a problem while reading from the file!");
        }

    }
}