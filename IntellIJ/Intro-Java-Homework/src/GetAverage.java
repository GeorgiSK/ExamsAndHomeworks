/**
 * Created by Windows on 3/15/2016.
 */
import java.util.Scanner;

public class GetAverage {
    public static void main(String[] args) {
        //setting up a scanner for catching user input
        Scanner scanner = new Scanner(System.in);

        //getting user input
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        double z = scanner.nextDouble();

        //calling the method that we created bellow
        double result = getAverageOfThree(x, y, z);

        //Printing the result using the printf method for formatting
        System.out.printf("%.2f\n", result);
    }
    //Creating a method that returns the average of three numbers
    static double getAverageOfThree(double numOne, double numTwo, double numThree) {
        double sum = numOne + numTwo + numThree;
        double average = sum / 3;

        return average;
    }
}
