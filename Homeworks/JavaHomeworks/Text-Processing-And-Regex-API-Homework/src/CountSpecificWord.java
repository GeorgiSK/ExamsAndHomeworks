import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSpecificWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine().toLowerCase();
        String subString = scanner.nextLine();

        String regex = "\\b" + subString + "\\b";

        Pattern pattern = Pattern.compile(regex);
        //Adding input to matcher
        Matcher matcher = pattern.matcher(line);
        int matches = 0;
        while (matcher.find()) {
            if (matcher.group().equals(subString)) matches++;
        }
        System.out.println(matches);
    }
}
