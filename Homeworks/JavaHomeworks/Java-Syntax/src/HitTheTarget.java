import java.util.Scanner;

/**
 * Created by Windows on 3/18/2016.
 */
public class HitTheTarget {
    public static void main(String[] args) {
        //Scanning user input
        Scanner scanner = new Scanner(System.in);

        //Saving user input
        int target = scanner.nextInt();

        //Printing the addition part
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i + j == target) {
                    System.out.printf("%d + %d = %d\n", i, j, target);
                }
            }
        }

        //Printing the substraction part
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (j - i == target) {
                    System.out.printf("%d - %d = %d\n", j, i, target);
                }
            }
        }
    }
}
