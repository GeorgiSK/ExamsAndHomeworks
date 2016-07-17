import java.util.Scanner;

/**
 * Created by Windows on 3/28/2016.
 */
public class Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().replaceAll("[0-9]");

        for (String s : input) {
            System.out.println(s);
        }
    }
}
