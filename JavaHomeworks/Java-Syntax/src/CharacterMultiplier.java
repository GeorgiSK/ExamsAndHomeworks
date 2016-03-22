import java.util.Scanner;

/**
 * Created by Windows on 3/18/2016.
 */
public class CharacterMultiplier {
    public static void main(String[] args) {
        //Scanning user input
        Scanner scanner = new Scanner(System.in);

        //Saving user input
        String firstString = scanner.next();
        String secondString = scanner.next();

        //Declaring a variable to hold the result
        int result = sumCharactersValues(firstString, secondString);

        System.out.println(result);
    }

    static int sumCharactersValues(String firstString, String secondString) {
        int result = 0;

        //A condition to check which variable's length is bigger
        if (firstString.length() > secondString.length()) {
            int i;

            //A loop that multiplies the characters codes up until the length of the second string
            for (i = 0; i < secondString.length(); i++) {
                result += secondString.charAt(i) * firstString.charAt(i);
            }

            //A loop that finishes up by adding the remaining characters from the first array
            for (int y = i; y <= firstString.length() - secondString.length(); y++) {
                result += firstString.charAt(y);
            }
        }else if (secondString.length() > firstString.length()) {
            int i;

            //A loop that multiplies the characters codes up until the length of the first string
            for (i = 0; i < firstString.length(); i++) {
                result += firstString.charAt(i) * secondString.charAt(i);
            }

            //A loop that finishes up by adding the remaining characters from the second array
            for (int y = i; y <= secondString.length() - firstString.length(); y++) {
                result += secondString.charAt(y);
            }
        }else {
            //A case that takes care of the multiplication if the length of the two strings is the same
            for (int i = 0; i < firstString.length(); i++) {
                result += firstString.charAt(i) * secondString.charAt(i);
            }
        }

        return result;
    }
}
