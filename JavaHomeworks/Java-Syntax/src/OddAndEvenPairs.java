import java.util.Scanner;

/**
 * Created by Windows on 3/17/2016.
 */
public class OddAndEvenPairs {
    public static void main(String[] args) {
        //Scanning user input
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] numbers = input.split(" ");

        for (int i = 0; i < numbers.length; i += 2) {
            if(numbers.length % 2 == 0) {
                if (Integer.parseInt(numbers[i]) % 2 == 0 && Integer.parseInt(numbers[i + 1]) % 2 == 0) {
                    System.out.printf("%s, %s -> both are even \n", numbers[i], numbers[i + 1]);
                } else if (Integer.parseInt(numbers[i]) % 2 != 0 && Integer.parseInt(numbers[i + 1]) % 2 != 0) {
                    System.out.printf("%s, %s -> both are odd \n", numbers[i], numbers[i + 1]);
                } else {
                    System.out.printf("%s, %s -> different \n", numbers[i], numbers[i + 1]);
                }
            }else {
                System.out.println("Invalid length");
                break;
            }
        }





    }
}
