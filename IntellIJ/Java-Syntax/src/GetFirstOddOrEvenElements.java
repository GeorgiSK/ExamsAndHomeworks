import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Windows on 3/18/2016.
 */
public class GetFirstOddOrEvenElements {
    public static void main(String[] args) {
        //Scanning user input
        Scanner scanner = new Scanner(System.in);

        //Saving user input
        String numbersString = scanner.nextLine();
        String orderString = scanner.nextLine();

        //Converting user input
        String[] arrayOfNumbers = numbersString.split(" ");
        String[] orderArray = orderString.split(" ");

        //Making a list to hold our final result
        List<Integer> resultArray = getFirstOddOrEven(arrayOfNumbers, orderArray[2], Integer.parseInt(orderArray[1]));

        //Printing the result on the console
        for (int n: resultArray) {
            System.out.printf("%d ", n);
        }
    }

    //This function returns a List with Odd/Even numbers with size = numbersCount or less if the input array has less Odd/Even numbers
    static List<Integer> getFirstOddOrEven(String[] numbersArray, String oddOrEven, int numbersCount) {
        List<Integer> result = new ArrayList<>();

        //This condition checks whether the input requires Odd or Even numbers
        if (oddOrEven.equals("even")){
            //This loop extracts all the even numbers from the input array
            for (int i = 0; i < numbersArray.length; i++) {
                //This section makes sure that the numbers extracted are <= the numbersCount variable
                if(numbersCount >= result.size()) {
                    //This condition filters out all odd numbers
                    if (Integer.parseInt(numbersArray[i]) % 2 == 0) {
                        result.add(Integer.parseInt(numbersArray[i]));
                    }
                }else {
                    break;
                }
            }
        }else {
            //This loop extracts all the odd numbers from the input array
            for (int i = 0; i < numbersArray.length; i++) {
                //This section makes sure that the numbers extracted are <= the numbersCount variable
                if(numbersCount >= result.size()) {
                    //This condition filters out all even numbers
                    if (Integer.parseInt(numbersArray[i]) % 2 != 0) {
                        result.add(Integer.parseInt(numbersArray[i]));
                    }
                }else {
                    break;
                }
            }
        }

        return result;
    }
}
