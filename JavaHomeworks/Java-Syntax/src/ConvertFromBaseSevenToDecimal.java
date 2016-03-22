import java.util.Scanner;

/**
 * Created by Windows on 3/17/2016.
 */
public class ConvertFromBaseSevenToDecimal {
    public static void main(String[] args) {
        //Scanning user input
        Scanner scanner = new Scanner(System.in);

        //Saving user input
        String input = scanner.nextLine();

        //Converting from base 7 to base 10
        int inputAfterConversion = Integer.parseInt(input, 7);

        //Printing the converted variable
        System.out.println(inputAfterConversion);
    }
}
