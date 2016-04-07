import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartsAndEndsWithCapital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine().trim();

        String regex = "\\b[A-Z][a-zA-Z]+[\\s\\n]";

        Pattern pattern = Pattern.compile(regex);
        //Adding input to matcher
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}
