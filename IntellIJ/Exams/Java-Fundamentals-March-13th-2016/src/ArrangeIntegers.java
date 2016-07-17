import java.util.*;


public class ArrangeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().trim().split("[ ,]+");
        List<String> integerWords = new LinkedList<>();

        for (int i = 0; i < numbers.length; i++) {
            char[] number = numbers[i].toCharArray();
            String currentNum = numToWord(number[0]);
            for (int j = 0; j < number.length - 1; j++) {
                currentNum += "-" + numToWord(number[j + 1]);
            }
            integerWords.add(currentNum);
        }

        Collections.sort(integerWords, (a,b) -> a.compareTo(b));


        for (int i = 0; i < integerWords.size(); i++) {
            String currNum = wordToNum(integerWords.get(i));
            integerWords.set(i, currNum);
        }

        String output = integerWords.toString().replace('[', '\0').replace(']', '\0');
        System.out.println(output);

    }

    static String numToWord(char num) {
        String number = new String();
        switch (num) {
            case '0':
                number = "zero";
                break;
            case '1':
                number = "one";
                break;
            case '2':
                number = "two";
                break;
            case '3':
                number = "three";
                break;
            case '4':
                number = "four";
                break;
            case '5':
                number = "five";
                break;
            case '6':
                number = "six";
                break;
            case '7':
                number = "seven";
                break;
            case '8':
                number = "eight";
                break;
            case '9':
                number = "nine";
                break;
        }

        return number;
    }

    static String wordToNum(String word) {
        String number = new String();

        if (word.length() == 1) return wordToDigit(word);
        else {
            String[] digits = word.split("-");

            for (int i = 0; i < digits.length; i++) {
                number += wordToDigit(digits[i]);
            }
        }
        return number;
    }

    static String wordToDigit(String word) {
        String number = new String();
        switch (word) {
            case "zero":
                number = "0";
                break;
            case "one":
                number = "1";
                break;
            case "two":
                number = "2";
                break;
            case "three":
                number = "3";
                break;
            case "four":
                number = "4";
                break;
            case "five":
                number = "5";
                break;
            case "six":
                number = "6";
                break;
            case "seven":
                number = "7";
                break;
            case "eight":
                number = "8";
                break;
            case "nine":
                number = "9";
                break;
        }

        return number;
    }
}
