import java.util.Scanner;

/**
 * Created by Windows on 3/23/2016.
 */
public class Recursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        printNumbers(n);
    }

    static void printNumbers(int n) {
        if (n < 1){
            return;
        }

        printNumbers(n - 1);
        System.out.println(n);
    }
}
