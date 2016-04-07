import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String regex = "[A-Za-z]+";

        Pattern pattern = Pattern.compile(regex);
        //Adding input to matcher
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }

    }
}
