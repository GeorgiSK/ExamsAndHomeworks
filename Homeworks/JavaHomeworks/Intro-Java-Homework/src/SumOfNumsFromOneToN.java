/**
 * Created by Windows on 3/15/2016.
 */
import java.util.Scanner;

public class SumOfNumsFromOneToN {
    public static void main(String[] args) {
        //setting up a scanner for catching user input
        Scanner scanner = new Scanner(System.in);

        //getting user input
        int n = Integer.parseInt(scanner.next());
        int sum = 0;        //This variable is used to store the sum of the numbers

        //This loop calculates the sum of the numbers
        for (int i = 1; i <= n ; i++) {
            sum += i;
        }

        System.out.println(sum);

    }
}
