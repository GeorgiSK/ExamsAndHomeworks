import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniDefendSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String regex = "([A-Z][a-z]+).*?([A-Z][a-z]*[A-Z]).*?(\\d+)L";
        int totalLiters = 0;

        while (!(input = scanner.nextLine()).equals("OK KoftiShans")) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String name = matcher.group(1);
                String alcoholType = matcher.group(2);
                String alcoholAmount = matcher.group(3);

                System.out.println(name + " brought " + alcoholAmount + " liters of " + alcoholType.toLowerCase() + "!");
                totalLiters += Integer.parseInt(alcoholAmount);
            }
        }

        double result = totalLiters / 1000;
        System.out.printf("%.3f softuni liters", totalLiters / 1000.0);

    }
}
