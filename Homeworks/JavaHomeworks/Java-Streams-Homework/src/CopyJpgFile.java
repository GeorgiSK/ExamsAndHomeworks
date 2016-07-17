import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyJpgFile {
    //Declaring constant variables for the path to the files
    private static final String FILE_PATH_IN = "my-original-picture.jpg";
    private static final String FILE_PATH_OUT = "my-copied-picture.jpg";

    public static void main(String[] args) {
        //Instantiating new files for reference
        File fileIn = new File(FILE_PATH_IN);
        File fileOut = new File(FILE_PATH_OUT);
        //This variable holds the size in bytes of a file
        int fileSize = (int)fileIn.length();

        //The buffer stores the contents of the file (This wont work for bigger files but the assignment requires us to use an array)
        byte[] buffer = new byte[fileSize];

        try(FileInputStream input = new FileInputStream(fileIn)) {
            //here the file is read and the contents are filled in the buffer
            input.read(buffer);

            try (FileOutputStream output = new FileOutputStream(fileOut)) {
                //Here the contents of the buffer are written in the new file
                output.write(buffer);
            }catch (Exception ex) {
                //If problem occurs during the writing to the file this message gets printed
                System.out.println("There was a problem while writing to the file!");
            }
        }catch (Exception ex) {
            //If problem occurs during the reading of the file this message gets printed
            System.out.println("There was a problem while reading from the file!");
        }
    }
}
