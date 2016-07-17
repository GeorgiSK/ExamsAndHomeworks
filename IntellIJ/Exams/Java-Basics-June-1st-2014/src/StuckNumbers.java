import java.util.Scanner;

public class StuckNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        // Find and print all stuck numbers {a, b, c, d}
        int count = 0;
        for (int num1 = 0; num1 < nums.length; num1++) {
            for (int num2 = 0; num2 < nums.length; num2++) {
                for (int num3 = 0; num3 < nums.length; num3++) {
                    for (int num4 = 0; num4 < nums.length; num4++) {
                        int a = nums[num1];
                        int b = nums[num2];
                        int c = nums[num3];
                        int d = nums[num4];
                        if (a != b && a != c & a != d &&
                                b != c && b != d && c != d) {
                            String first = "" + a + b;
                            String second = "" + c + d;
                            if (first.equals(second)) {
                                System.out.printf("%d|%d==%d|%d\n",
                                        a, b, c, d);
                                count++;
                            }
                        }
                    }
                }
            }
        }

        if (count == 0) {
            System.out.println("No");
        }
    }
    }

