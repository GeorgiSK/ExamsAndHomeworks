import java.io.*;

public class CountCharacterTypes {
    //Declaring constant variables for the path to the files
    private static final String FILE_PATH_IN = "words.txt";
    private static final String FILE_PATH_OUT = "count-chars.txt";

    public static void main(String[] args) {
        //Instantiating new files for reference
        File fileIn = new File(FILE_PATH_IN);
        File fileOut = new File(FILE_PATH_OUT);

        try(BufferedReader reader = new BufferedReader(new FileReader(fileIn))) {
            //This is the line that we are checking (converted to lower case for convenience)
            String line = reader.readLine().toLowerCase();
            //Variables to store our numbers
            int numOfVowels = 0;
            int numOfConsonants = 0;
            int numOfPunctuationSigns = 0;

            //This loop iterates through the whole string while calculating vowels, consonants, etc..
            for (int i = 0; i < line.length(); i++) {
                //Here we check whether the character at the position is a vowel
                if(line.charAt(i) == 'a' ||
                        line.charAt(i) == 'e' ||
                        line.charAt(i) == 'i' ||
                        line.charAt(i) == 'o' ||
                        line.charAt(i) == 'u') {
                    numOfVowels++;
                    //Here we check whether the character at the position is punctuation
                }else if(line.charAt(i) == '?' ||
                            line.charAt(i) == '.' ||
                            line.charAt(i) == ',' ||
                            line.charAt(i) == '!') {
                    numOfPunctuationSigns++;
                    //In the else we also check if the character at the position is s space and if it isn't it must be a consonant
                }else {
                    if(line.charAt(i) == ' ') {
                        continue;
                    }else {
                        numOfConsonants++;
                    }
                }
            }

            //This section is takes care of formatting and printing the gathered information in the file
            try(PrintWriter writer = new PrintWriter(new FileWriter(fileOut))) {
                writer.println("Vowels: " + numOfVowels +
                        "\r\nConsonants: " + numOfConsonants +
                        "\r\nPunctuation: " + numOfPunctuationSigns);
            }catch (Exception ex){
                //If problem occurs during the writing to the file this message gets printed
                System.out.println("There was a problem while writing to the file!");
            }

        }catch(Exception ex) {
            //If problem occurs during the reading of the file this message gets printed
            System.out.println("There was a problem while reading from the file!");
        }
    }
}
