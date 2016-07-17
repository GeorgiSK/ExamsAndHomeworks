import java.util.Scanner;

public class NFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        System.out.println(factorial(input));
    }

    static int factorial(int n) {
        if (n == 1 || n == 0) return 1;
        else return n * factorial(n - 1);
    }
}
