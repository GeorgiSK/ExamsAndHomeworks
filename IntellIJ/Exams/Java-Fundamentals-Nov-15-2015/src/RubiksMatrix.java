import java.util.Arrays;
import java.util.Scanner;

public class RubiksMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();
        int numOfCommands = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[r][c];
        int[][] test = new int[r][c];
        int counter = 1;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = counter;
                test[i][j] = counter;
                counter++;
            }
        }


        for (int i = 0; i < numOfCommands; i++) {
            String[] command = scanner.nextLine().trim().split("\\s+");
            String direction = command[1];
            int firstNum = Integer.parseInt(command[0]);
            int numOfTimes = Integer.parseInt(command[2]);
            if (firstNum <= 0 || numOfTimes <= 0) continue;

            if (direction.equals("left")) {
                for (int j = 0; j < numOfTimes; j++) {
                    int elZero = matrix[firstNum][0];
                    for (int k = 0; k < matrix[firstNum].length - 1; k++) {
                        matrix[firstNum][k] = matrix[firstNum][k + 1];
                    }
                    matrix[firstNum][matrix[firstNum].length - 1] = elZero;
                }
            }
            else if (direction.equals("right")) {
                for (int j = 0; j < numOfTimes; j++) {
                    int lastElement = matrix[firstNum][matrix[firstNum].length - 1];
                    for (int k = matrix[firstNum].length - 1; k > 0 ; k--) {
                        matrix[firstNum][k] = matrix[firstNum][k - 1];
                    }
                    matrix[firstNum][0] = lastElement;
                }
            }
            else if (direction.equals("up")) {
                for (int j = 0; j < numOfTimes; j++) {
                    int firstElement = matrix[0][firstNum];
                    for (int k = 0; k < matrix.length - 1; k++) {
                        matrix[k][firstNum] = matrix[k + 1][firstNum];
                    }
                    matrix[matrix.length - 1][firstNum] = firstElement;
                }
            }
            else {
                for (int j = 0; j < numOfTimes; j++) {
                    int lastElement = matrix[matrix.length - 1][firstNum];
                    for (int k = matrix.length - 1; k > 0; k--) {
                        matrix[k][firstNum] = matrix[k - 1][firstNum];
                    }
                    matrix[0][firstNum] = lastElement;
                }
            }
        }


        counter = 1;
        boolean isFound = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != test[i][j]) {
                    isFound = false;
                    for (int k = 0; k < matrix.length; k++) {
                        for (int l = 0; l < matrix[k].length; l++) {
                            if (matrix[k][l] == test[i][j]) {
                                System.out.printf("Swap (%d, %d) with (%d, %d)\n", i, j, k, l);
                                int temp = matrix[i][j];
                                matrix[i][j] = matrix[k][l];
                                matrix[k][l] = temp;
                                isFound = true;
                                break;
                            }
                        }

                        if (isFound) break;
                    }
                }else {
                    System.out.println("No swap required");
                }
            }
        }

       // Arrays.stream(matrix).forEach(e -> {
       //     Arrays.stream(e).forEach(System.out::println);
       // });
    }
}
