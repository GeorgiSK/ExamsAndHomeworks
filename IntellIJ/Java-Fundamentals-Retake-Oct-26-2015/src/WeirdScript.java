import java.util.Scanner;

/**
 * Created by Windows on 4/16/2016.
 */
public class WeirdScript {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String input;

        char letter;
        int counter = 0;

        for (int i = 0; i < n; i++) {
            int sum = counter + 97;
            letter = (char)sum;

            if (counter <= 26) {
                counter = 0;

            }
        }

        while (!(input = scanner.nextLine()).equals("End")) {

        }

    }

    public static String swapCaps(String caps) {
        return null;
    }
}
