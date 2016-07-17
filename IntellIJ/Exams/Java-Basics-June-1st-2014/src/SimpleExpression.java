import java.math.BigDecimal;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

public class SimpleExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().trim().split("[ ]+");
        String expression = new String();
        for (int i = 0; i < line.length; i++) {
            expression += line[i];
        }
        String[] numbers = expression.split("[+-]");
        String[] operators = expression.split("[0-9]+([,.][0-9]+)?");

        BigDecimal result =new BigDecimal(numbers[0]);
        int j = 1;
        for (int i = 1; i < numbers.length; i++) {
            BigDecimal currNum = new BigDecimal(numbers[i]);
            if (operators[j].equals("")){
                if (j == operators.length - 1) break;
                j++;
            }

            if (operators[j].equals("+")) result = result.add(currNum);
            else if (operators[j].equals("-"))result = result.subtract(currNum);
            else {
                throw new IllegalArgumentException(
                        "Invalid operator: " + operators[i]);
            }
            j++;
        }

        System.out.println(result);
    }
}
