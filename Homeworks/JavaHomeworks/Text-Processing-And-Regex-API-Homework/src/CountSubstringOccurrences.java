import java.util.Scanner;

public class CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine().toLowerCase().trim();
        String subString = scanner.nextLine().trim();

        int matches = 0;

        for (int i = 0; i < line.length() - subString.length() + 1; i++) {
            String currentCheck = "";
            for (int j = i; j < subString.length() + i; j++) {
                currentCheck += line.charAt(j);
            }

            if (subString.equals(currentCheck)) matches++;
        }

        System.out.println(matches);
    }
}
