import java.util.Scanner;

/**
 * Created by Windows on 3/17/2016.
 */
public class FormattingNumbers {
    public static void main(String[] args) {
        //Scanning user input
        Scanner scanner = new Scanner(System.in);

        //Creating variables that will hold our values
        int a = scanner.nextInt();
        String aToHexString = String.format("%-10s", Integer.toHexString(a).toUpperCase());
        String aToBinaryString = String.format("%10s", Integer.toBinaryString(a)).replace(' ', '0');
        float b = scanner.nextFloat();
        float c = scanner.nextFloat();

        //printing everything on the console formatted accordingly
        System.out.printf("|%s|%s|%10.2f|%-10.3f|", aToHexString, aToBinaryString, b, c);
    }
}
