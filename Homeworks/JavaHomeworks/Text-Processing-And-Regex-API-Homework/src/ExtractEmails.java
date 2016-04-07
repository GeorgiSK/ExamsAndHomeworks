import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //This regex matches all possible emails in the input string
        String regex = "[A-z0-9]+[a-z0-9.-_]*[A-z0-9]+[@][A-z]+[.-]*[a-z]+[.-][a-z]+";
        //Getting user input
        String emails = scanner.nextLine().trim();
        //Compiling the regex
        Pattern pattern = Pattern.compile(regex);
        //Adding input to matcher
        Matcher matcher = pattern.matcher(emails);

        //Printing out matches
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
