import java.util.Scanner;

public class SequenceOfEqualStrings {
    public static void main(String[] args) {
        //Creating a scanner for user input
        Scanner scanner = new Scanner(System.in);

        //Saving user input
        String input = scanner.nextLine();
        String[] words = input.split(" ");

        //This code checks if the array has only one element
        if (words.length == 1) {
            System.out.println(words[0]);
        }else {
            //The array starts at 1 so there are no array index out of bounds exceptions
            for (int i = 1; i < words.length; i++) {
                //This code checks if the previous element is the same
                // as this one and if it is it prints the prev element without a new line
                //else it prints it with a new line
                if (words[i - 1].equals(words[i])) {
                    System.out.print(words[i - 1] + " ");
                }else {
                    System.out.println(words[i - 1]);
                }

                //This code makes sure that the last element always gets printed
                if (i == words.length - 1) {
                    if (words[i].equals(words[i - 1])) {
                        System.out.print(words[i]);
                    }else {
                        System.out.printf(words[i]);
                    }
                }
            }
        }
    }
}
