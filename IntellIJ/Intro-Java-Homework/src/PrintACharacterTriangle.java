/**
 * Created by Windows on 3/14/2016.
 */
import java.util.Scanner;

public class PrintACharacterTriangle {
    public static void main(String[] args) {

        //setting up a scanner for catching user input
        Scanner scanner = new Scanner(System.in);

        //getting user input
        int n = Integer.parseInt(scanner.next());

        int loopVar = 0;                    //This variable is used for printing the second half of the triangle
        int triangleBaseLenght = n * 2;     //This variable represents the length of the base of our triangle
        int asciiConvertionVar = 97;        //This variable is used to convert user input to an ASCII character code

        //This outer loop that prints the whole triangle
        for (int i = 0; i < triangleBaseLenght ; i++) {

            if (i <= triangleBaseLenght / 2) {
                //This inner loop prints the top half of the triangle
                for (char j = 'a'; j < i + asciiConvertionVar; j++) {
                    System.out.print((j + " "));
                }
                loopVar = i;
            }else {
                //This inner loop prints the bottom half of the triangle
                for (char j = 'a'; j < loopVar + asciiConvertionVar; j++) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
            loopVar--;
        }

    }
}
