import java.util.Scanner;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int value = Integer.parseInt(scanner.nextLine());
        String[] line = scanner.nextLine().split(" ");
        int[] numbers = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        System.out.println(binarySearch(numbers, value, 0, numbers.length - 1));
    }

    static int binarySearch(int[] array, int value, int start, int end) {
        if (end - start <= 1) {
            if(array[start] == value) {
                return start;
            }
            if(array[end] == value) {
                return end;
            }
            return -1;
        }

        int midPoint = (start + end) /2;
        if (array[midPoint] > value) {
            return binarySearch(array, value, 0, midPoint);
        } else {
            return binarySearch(array, value, midPoint, end);
        }
    }
}
