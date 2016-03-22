import java.util.Random;
import java.util.Scanner;

/**
 * Created by Windows on 3/17/2016.
 */
public class RandomizeNums {
    public static void main(String[] args) {
        //Scanning user input
        Scanner scanner = new Scanner(System.in);

        //Getting user input
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        //The array that will hold the range of nums from a to b and vise versa
        int[] elements = new int[0];

        //Variables for randomizing
        Random random = new Random();
        int index;

        //Filling up the array
        if(a > b)
        {
            elements = new int[(a - b ) + 1];
            int j = 0;

            for (int i = b; i < a + 1; i++) {
                elements[j] = i;
                j++;
            }
        }else if(b > a){
            elements = new int[(b - a) + 1];
            int j = 0;

            for (int i = a; i < b + 1; i++) {
                elements[j] = i;
                j++;
            }
        }

        //Randomizing the elements of the array
        if (elements.length == 0)
        {
            System.out.println(a);
        }else {
            for (int i = elements.length - 1; i >= 0; i--) {

                index = random.nextInt(i + 1);

                if(index != i) {
                    int temp = elements[index];
                    elements[index] = elements[i];
                    elements[i] = temp;
                }
                //Printing the array
                System.out.print(elements[i] + " ");
            }
        }


    }
}
