/**
 * Created by Windows on 3/15/2016.
 */
import java.util.Arrays;
import java.util.Scanner;

public class GhettoNumeralSystem {
    public static void main(String[] args) {
        //setting up a scanner for catching user input
        Scanner scanner = new Scanner(System.in);

        //getting user input
        String input = scanner.nextLine();

        char[] individualNums = input.toCharArray();                    //Creating an array of characters with the user input
        String[] convertedArray = new String[individualNums.length];   //Creating the array that will hold the converted values

        //Switching the array of characters and making the conversion
        for (int i = 0; i < individualNums.length; i++) {
            switch(individualNums[i]) {
                case '0':
                    convertedArray[i] = "Gee";
                    break;
                case '1':
                    convertedArray[i] = "Bro";
                    break;
                case '2':
                    convertedArray[i] = "Zuz";
                    break;
                case '3':
                    convertedArray[i] = "Ma";
                    break;
                case '4':
                    convertedArray[i] = "Duh";
                    break;
                case '5':
                    convertedArray[i] = "Yo";
                    break;
                case '6':
                    convertedArray[i] = "Dis";
                    break;
                case '7':
                    convertedArray[i] = "Hood";
                    break;
                case '8':
                    convertedArray[i] = "Jam";
                    break;
                case '9':
                    convertedArray[i] = "Mack";
                    break;
            }
        }

        //Printing the converted array on the console
        for (String n: convertedArray) {
            System.out.print(n);
        }


    }
}
