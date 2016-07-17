import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicMarkUpLanguage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        String regex = "<([A-z]+)|\"(.*?)\"";
        List<String> command = new ArrayList<>();
        int currentIteration = 1;

        while (!(input =  scanner.nextLine()).equals("<stop/>")) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()){
                command.add(matcher.group(1));
                if (matcher.find()) command.add(matcher.group(2));
                if (matcher.find()) command.add(matcher.group(2));
            }

            command.removeAll(Arrays.asList("", null));
            command.removeAll(Arrays.asList(" ", null));

            if (command.size() == 2) {
                if (command.get(1).length() > 50 && command.get(1).length() < 1) command.clear();
            }
            if (command.size() == 3) {
                if (Integer.parseInt(command.get(1)) > 10 && Integer.parseInt(command.get(1)) < 1) command.clear();
            }

            if (command.size() < 2)  {
                command.clear();
                continue;
            }

            ///////////////////////////////////////////////
            if (command.get(0).equals("inverse")) {
                inverse(command, currentIteration);
                currentIteration++;
            }else  if (command.get(0).equals("reverse")) {
                reverse(command, currentIteration);
                currentIteration++;
            }else if (command.get(0).equals("repeat"))  {
                int repetitions = Integer.parseInt(command.get(1));
                for (int i = 0; i < repetitions; i++) {
                    System.out.println(currentIteration + ". " + command.get(2));
                    currentIteration++;
                }
            }
            ///////////////////////////////////////////////
            command.clear();
        }
    }

    static void inverse(List<String> command, int currentIteration) {
        char[] letters = command.get(1).toCharArray();

        System.out.print(currentIteration + ". ");
        for (int i = 0; i < letters.length; i++) {
            if (Character.isUpperCase(letters[i])) System.out.print(Character.toLowerCase(letters[i]));
            else System.out.print(Character.toUpperCase(letters[i]));
        }
        System.out.println();
    }

    static void reverse(List<String> command, int currentIteration) {
        char[] letters = command.get(1).toCharArray();

        System.out.print(currentIteration + ". ");
        for (int i = letters.length - 1; i >= 0; i--) {
            System.out.print(letters[i]);
        }
        System.out.println();
    }
}
