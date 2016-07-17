import java.util.Scanner;

/**
 * Created by Windows on 3/17/2016.
 */
public class CalculateExpression {
    public static void main(String[] args) {
        //Scanning user input
        Scanner scanner = new Scanner(System.in);

        float a = scanner.nextFloat();
        float b = scanner.nextFloat();
        float c = scanner.nextFloat();

        //Doing equations for the first formula
        double formulaOneExponent = (a + b + c) / Math.sqrt(c);
        double formulaOneBase = ((Math.pow(a, 2) + Math.pow(b, 2)) / (Math.pow(a, 2) - Math.pow(b, 2)));
        double formulaOneResult = Math.pow(formulaOneBase, formulaOneExponent);

        //Doing equations for the second formula
        double formulaTwoExponent = a - b;
        double formulaTwoBase = Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3);
        double formulaTwoResult = Math.pow(formulaTwoBase, formulaTwoExponent);

        //Doing equations for the averages and the difference
        double numbersAverage = (a + b + c) / 3;
        double formulasAverage = (formulaOneResult + formulaTwoResult ) / 2;
        double difference = Math.abs(numbersAverage - formulasAverage);

        //Printing the retrieved values with the appropriate formatting
        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", formulaOneResult, formulaTwoResult, difference);
    }
}
