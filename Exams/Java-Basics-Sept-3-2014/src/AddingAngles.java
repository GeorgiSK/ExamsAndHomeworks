import java.util.Scanner;

public class AddingAngles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] angles = new int[n];

        for (int i = 0; i < n; i++) {
            angles[i] = scanner.nextInt();
        }

        boolean hadPrinted = false;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                for (int c = b + 1; c < n; c++) {
                    if (a != b && a != c && b != c) {
                        if ((angles[a] + angles[b] + angles[c]) % 360 == 0) {
                            System.out.printf("%d + %d + %d = %d degrees\n", angles[a], angles[b], angles[c], (angles[a] + angles[b] + angles[c]));
                            hadPrinted = true;
                        }
                    }
                }
            }
        }

        if (!hadPrinted) {
            System.out.println("No");
        }
    }
}
