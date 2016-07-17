import java.util.Scanner;

public class WeirdStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("[\\\\/|() ]+");
        String inputStageTwo = new String();

        for (String s : input) {
            inputStageTwo += s;
        }
        String[] words = inputStageTwo.split("[^A-z]+");
        int[] sums = new int[words.length];
        int[] consecutiveSums = new int[sums.length - 1];
        int largestSum = 0;
        int largestSumIndex = 0;

        for (int i = 0; i < words.length; i++) {
            sums[i] = getStringValue(words[i]);
        }

        for (int i = 0; i < sums.length - 1; i++) {
            consecutiveSums[i] = sums[i] + sums[i + 1];
        }

        for (int i = 0; i < consecutiveSums.length; i++) {
            if (consecutiveSums[i] >= largestSum) {
                largestSum = consecutiveSums[i];
                largestSumIndex = i;
            }
        }

        System.out.println(words[largestSumIndex]);
        System.out.println(words[largestSumIndex + 1]);


    }

    public static int getStringValue(String string) {
        int sum = 0;
        String s = string.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            sum += currentChar - 96;
        }
        return sum;
    }
}
