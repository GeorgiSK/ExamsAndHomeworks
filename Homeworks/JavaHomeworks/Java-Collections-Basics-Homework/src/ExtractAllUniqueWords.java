import java.util.Scanner;
import java.util.TreeSet;

public class ExtractAllUniqueWords {

    public static void main(String[] args) {
        //Creating a scanner for user input
        Scanner scanner = new Scanner(System.in);

        //Saving user input in a variable
        String[] input = scanner.nextLine().split("[-'.:? ]");
        //The Tree set orders alphabetically and does not allow repetition so it is perfect for the occasion
        TreeSet<String> extractedElements = new TreeSet<>();

        //Here we fill up the set
        for (String s : input) {
            if(!s.equals(""))extractedElements.add(s.toLowerCase());
        }

        System.out.println(extractedElements);
    }
}
