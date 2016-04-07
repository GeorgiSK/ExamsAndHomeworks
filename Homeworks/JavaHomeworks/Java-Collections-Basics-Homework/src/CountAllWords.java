import java.util.Scanner;

public class CountAllWords {
    public static void main(String[] args) {
        //Creating a scanner for user input
        Scanner scanner = new Scanner(System.in);

        //Saving user input in a variable
        String input = scanner.nextLine();
        //splitting the variable in an array by a few delimiters
        String[] elements = input.split("[-' ]");

        //printing the length of the array
        System.out.println(elements.length);
    }
}
