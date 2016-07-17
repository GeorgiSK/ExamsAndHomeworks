import java.util.Arrays;
import java.util.Scanner;

public class FilterArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArray = scanner.nextLine().split(" ");

        Arrays.stream(inputArray).filter(el -> el.length() > 3).forEach(word -> {
            System.out.print(word + " ");
        });
    }
}
