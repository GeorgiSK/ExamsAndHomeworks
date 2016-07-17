import java.util.Scanner;

public class LargestSequenceOfEqualStrings {
    public static void main(String[] args) {
        //Creating a scanner for user input
        Scanner scanner = new Scanner(System.in);

        //Saving user input
        String input = scanner.nextLine();
        String[] words = input.split(" ");
        String bestElement = "";
        int frequency = 1;
        int bestFrequency = 0;

        //This code checks if the array has only one element
        if (words.length == 1) {
            System.out.println(words[0]);
        }else {
            //The array starts at 1 so there are no array index out of bounds exceptions
            for (int i = 1; i < words.length; i++) {
                //This code checks if the previous element is the same
                // as this one and if it is it increases the frequency and sets the
                // current element as the best element
                //else it prints it with a new line
                if (words[i - 1].equals(words[i])) {
                    frequency++;
                    if(frequency > bestFrequency) {
                        bestElement = words[i - 1];
                        bestFrequency = frequency;
                    }
                }else {
                    frequency = 1;
                }

                //This code makes sure that the last element always gets in the equation
                if( frequency>bestFrequency){
                    bestElement=words[words.length - 1];
                    bestFrequency=frequency;
                }
            }
        }

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(bestElement)) {
                System.out.print(words[i] + " ");
            }
        }
    }
}


