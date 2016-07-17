import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class LongestIncreasingSequence {
    public static void main(String[] args) {
        //Creating a scanner for user input
        Scanner scanner = new Scanner(System.in);

        //Saving user input
        String input = scanner.nextLine();
        //splitting user input into an array
        String[] words = input.split(" ");
        //This var keeps track of the longest sequence throughout the iteration
        String longestSequence = words[0];
        //This var keeps the data for every distinct sequence
        String currentSequence = "";
        //This var represents the last element which is before the one in the current iteration
        String lastElement = words[0];

        //This code checks if the array has only one element
        if (words.length == 1) {
            System.out.println(words[0]);
        }else {
            //In every iteration we add the last element and the current element to the currentSequence var
            for (int i = 1; i < words.length; i++) {
                currentSequence += lastElement + " ";
                System.out.print(lastElement + " ");
                currentSequence += words[i] + " ";

                //Then we check if those two variables (last and current) are in a sequence
                if (Integer.parseInt(words[i]) <= Integer.parseInt(lastElement)) {
                    //If not we print a new line in order to start the next sequence on a new line
                    System.out.println();
                    //And then we reset the current sequence
                    currentSequence = "";
                } else {
                    //If they are we keep the current sequence and set it as the longest for the particular itteration
                    if (currentSequence.length() > longestSequence.length()) {
                        longestSequence = currentSequence;
                    }
                }
                //After all that we update our last element
                lastElement = words[i];

                //Here we check if we are on the last iteration
                if (i == words.length - 1) {
                    //If we are we print the last element with the appropriate formatting (with or without new line)
                    if (Integer.parseInt(words[i]) > Integer.parseInt(lastElement)) System.out.print(words[i]);
                    else System.out.println(words[i]);
                }
            }

        }

        //Because the previous algorithm isn't perfect and in duplicates some of the elements in the sequence
        //we create a TreeSet which does not allow duplication
        TreeSet<String> numbers = new TreeSet<>();

        //Here we transfer all the data in the TreeSet
        for (String word : longestSequence.split(" ")) {
            numbers.add(word);
        }
        System.out.println("Longest sequence: " + numbers);
    }
}
