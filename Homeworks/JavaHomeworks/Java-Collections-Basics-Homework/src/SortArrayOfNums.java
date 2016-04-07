import java.util.Arrays;
import java.util.Scanner;

public class SortArrayOfNums {
    public static void main(String[] args) {
        //Creating a scanner for user input
        Scanner scanner = new Scanner(System.in);

        //Saving user input
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        //This loop saves user input into an array
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        //Sorting the array
        Arrays.sort(numbers);

        //Printing the result
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
