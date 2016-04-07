import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    //Declaring constant variables for the path to the files
    private static final String FILE_ONE_PATH = "words.txt";
    private static final String FILE_TWO_PATH = "count-chars.txt";
    private static final String FILE_THREE_PATH = "lines.txt";

    public static void main(String[] args) {
        //Instantiating new files for reference
        File[] files = new File[3];
        files[0] = new File(FILE_ONE_PATH);
        files[1] = new File(FILE_TWO_PATH);
        files[2] = new File(FILE_THREE_PATH);

        //Here we open the Zip stream
        try (ZipOutputStream output = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("text-files.zip")))) {
            //This loop iterates through all the files, opens them, reads and copies everything from them to the files inside the .zip
            for (int i = 0; i < files.length; i++) {
                try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(files[i]))) {
                    byte[] buffer = new byte[(int)files[i].length()];
                    output.putNextEntry(new ZipEntry(files[i].getName()));
                    input.read(buffer);
                    output.write(buffer);
                    output.closeEntry();
                } catch (Exception e) {
                    //If problem occurs during the reading of the file this message gets printed
                    System.out.println("There was a problem while reading the file!");
                }
            }
        } catch (Exception e) {
            //If problem occurs during the writing to the file this message gets printed
            System.out.println("A problem occurred while writing to the file!");
        }



    }
}
