/**
 * Created by Windows on 3/22/2016.
 */
public class Sorting {
    public static void main(String[] args) {
        /*int[] numbers = new int[] {5, 10, 3, 2, 1};
        int j = 0;
        int temp;
        boolean swapped = true;

        while(swapped) {
            swapped = false;
            j++;

            for (int i = 0; i < numbers.length - j; i++) {
                if (numbers[i] > numbers[i + 1]){
                    temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                    swapped = true;
                }

            }
        }


        for (int number : numbers) {
            System.out.print(number + " ");
        }*/

        boolean isPrime = isPrime(457);

        System.out.println(isPrime);
    }

    public static boolean isPrime(int number) {
        for (int i = 3; i < number; i++) {
            if(number % i == 0) {
                return false;
            }
        }

        return true;
    }
}

