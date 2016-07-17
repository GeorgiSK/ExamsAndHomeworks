import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AllCapitals {
    //Declaring a constant variable for the path to the file
    private static final String FILE_PATH = "lines1.txt";

    public static void main(String[] args) {
        //Instantiating a new file for reference
        File file = new File(FILE_PATH);

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            //Getting input line by line
            String line = reader.readLine();
            //A list to temporary hold the lines
            List<String> lines = new ArrayList<>();

            //Getting all the lines into the list
            while (line != null) {
                lines.add(line.toUpperCase());
                line = reader.readLine();
            }

            try(PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                //Flushing the file
                writer.flush();
                //Writing it all over again with capital letters
                for (int i = 0; i < lines.size(); i++) {
                    writer.println(lines.get(i));
                }
            }catch(Exception ex){
                //If problem occurs during the writing to the file this message gets printed
                System.out.println("There was a problem while writing to the file!");
            }

        }catch(Exception ex) {
            //If problem occurs during the reading of the file this message gets printed
            System.out.println("There was a problem while reading from the file!");
        }
    }
}
