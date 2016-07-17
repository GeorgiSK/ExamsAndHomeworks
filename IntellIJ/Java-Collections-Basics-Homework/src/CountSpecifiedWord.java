import java.util.Scanner;

/**
 * Created by Windows on 3/27/2016.
 */
public class CountSpecifiedWord {
    public static void main(String[] args) {
        //Creating a scanner for user input
        Scanner scanner = new Scanner(System.in);

        //Saving user input in a variable
        String input = scanner.nextLine();
        //splitting the variable in an array by a few delimiters
        String[] sentence = input.split("[-' ]");
        String word = scanner.nextLine();
        int count = 0;

        for (String s : sentence) {
            if (s.toLowerCase().equals(word)) count++;
        }

        System.out.println(count);
    }
}
