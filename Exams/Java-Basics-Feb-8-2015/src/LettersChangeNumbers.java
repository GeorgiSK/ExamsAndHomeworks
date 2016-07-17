import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().trim().split("[ \\t]+");

        ArrayList<Double> sums = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            String leftLetter = Character.toString(strings[i].charAt(0));
            String rightLetter = Character.toString(strings[i].charAt(strings[i].length() - 1));
            double number = 0.0;

            Pattern p = Pattern.compile("[^A-Za-z]+");
            Matcher m = p.matcher(strings[i]);
            m.find();
            number = Double.parseDouble(m.group());

            if (Character.isLowerCase(leftLetter.charAt(0))) {
                number *= getCharacterPosition(leftLetter);
            }else {
                number /= getCharacterPosition(leftLetter);
            }

            if (Character.isLowerCase(rightLetter.charAt(0))) {
                number += getCharacterPosition(rightLetter);
            }else {
                number -= getCharacterPosition(rightLetter);
            }

            sums.add(number);
        }

        double totalSum = 0.0;

        for (Double sum : sums) {
            totalSum += sum;
        }

        System.out.printf("%.2f", totalSum);
    }

    public static int getCharacterPosition(String s) {
        return s.toLowerCase().charAt(0) - 96;
    }
}
