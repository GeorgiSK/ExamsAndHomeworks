import java.util.Scanner;

public class Durts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int centerX = scanner.nextInt();
        int centerY = scanner.nextInt();
        scanner.nextLine();
        int r = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] coordStrings = scanner.nextLine().replaceAll("\\n", " ").trim().split("[ ]+");
        int[] darts = new int[n * 2];

        for (int i = 0; i < n * 2; i++) {
            darts[i] = Integer.parseInt(coordStrings[i]);
        }

        for (int i = 0; i < darts.length; i += 2) {
            if (darts[i] <= centerX - r || darts[i] >= centerX + r) {
                if (darts[i + 1] <= centerY - r || darts[i + 1] >= centerY + r) {

                }
            }
        }

    }
}
