import java.util.Arrays;
import java.util.Scanner;

public class LegoBlocks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numOfRows = scanner.nextInt();
        scanner.nextLine();
        int[][] first = new int[numOfRows][];
        int[][] second = new int[numOfRows][];
        int totalNumOfElements = 0;
        boolean isRect = true;

        for (int i = 0; i < numOfRows; i++) {
            String[] numbers = scanner.nextLine().replaceAll("[^0-9]+", " ").trim().split("[^0-9]+");
            int[] col = new int[numbers.length];

            for (int j = 0; j < numbers.length; j++) {
                col[j] = Integer.parseInt(numbers[j]);
            }

            first[i] = col;
        }

        for (int i = 0; i < numOfRows; i++) {
            String[] numbers = scanner.nextLine().replaceAll("[^0-9]+", " ").trim().split("[^0-9]+");
            int[] col = new int[numbers.length];

            for (int j = 0; j < numbers.length; j++) {
                col[j] = Integer.parseInt(numbers[j]);
            }

            second[i] = col;
        }

        int[][] matrix = new int[numOfRows][];

        for (int i = 0; i < second.length; i++) {
            for (int j = 0; j < second[i].length / 2; j++) {
                int temp = second[i][j];
                second[i][j] = second[i][second[i].length - j - 1];
                second[i][second[i].length - j - 1] = temp;
            }
            totalNumOfElements += second[i].length + first[i].length;
            int[] result = new int[second[i].length + first[i].length];

            for (int j = 0; j < first[i].length; j++) {
                result[j] = first[i][j];
            }

            for (int j = first[i].length; j < first[i].length + second[i].length; j++) {
                result[j] = second[i][j - first[i].length];
            }

            matrix[i] = result;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i != j) {
                    if (matrix[i].length != matrix[j].length) {
                        isRect = false;
                        break;
                    }
                }
            }
        }

        if (isRect) {
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(Arrays.toString(matrix[i]));
            }
        }else {
            System.out.println("The total number of cells is: " + totalNumOfElements);
        }


    }
}
