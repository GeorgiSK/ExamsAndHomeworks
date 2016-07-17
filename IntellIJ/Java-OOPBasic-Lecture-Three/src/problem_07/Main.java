package problem_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (!(input = reader.readLine()).equals("End")) {
            String[] line = input.trim().split(" ");
            String operation = line[0];
            Double firstNum = Double.parseDouble(line[1]);
            Double secondNum = Double.parseDouble(line[2]);

            if (operation.equals("Sum")) {
                System.out.printf("%.2f\n", MathUtil.sum(firstNum, secondNum));
            }else if (operation.equals("Subtract")) {
                System.out.printf("%.2f\n", MathUtil.subtract(firstNum, secondNum));
            }else if (operation.equals("Multiply")) {
                System.out.printf("%.2f\n", MathUtil.multiply(firstNum, secondNum));
            }else if (operation.equals("Divide")) {
                System.out.printf("%.2f\n", MathUtil.devide(firstNum, secondNum));
            }else if (operation.equals("Percentage")) {
                System.out.printf("%.2f\n", MathUtil.percentage(firstNum, secondNum));
            }
        }
    }
}

class MathUtil {


    static Double sum(Double numOne, Double numTwo) {
        return numOne + numTwo;
    }

    static Double subtract(Double numOne, Double numTwo) {
        return numOne - numTwo;
    }

    static Double multiply(Double numOne, Double numTwo) {
        return numOne * numTwo;
    }

    static Double devide(Double devided, Double devidor) {
        return devided / devidor;
    }

    static Double percentage(Double totalNum, Double percent) {
        return totalNum * (percent / 100);
    }
}
