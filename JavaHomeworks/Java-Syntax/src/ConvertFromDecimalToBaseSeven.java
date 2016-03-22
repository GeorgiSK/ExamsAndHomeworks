import java.util.Scanner;

/**
 * Created by Windows on 3/17/2016.
 */
public class ConvertFromDecimalToBaseSeven {
    public static void main(String[] args) {
        //Scanning user input
        Scanner scanner = new Scanner(System.in);

        //Saving user input
        int input = scanner.nextInt();

        //Converting from base 10 to base 7
        String inputAfterConversion = Integer.toString(input, 7);

        System.out.println(inputAfterConversion);
    }
}
