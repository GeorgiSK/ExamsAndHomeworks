import java.util.Scanner;

public class DozenEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalEggs = 0;
        int dozens;
        int eggs;

        for (int i = 0; i < 7; i++) {
            String[] input = scanner.nextLine().trim().split("\\s+");

            if (input[1].equals("eggs")) {
                totalEggs += Integer.parseInt(input[0]);
            }else {
                totalEggs += Integer.parseInt(input[0]) * 12;
            }
        }

        dozens = totalEggs / 12;
        eggs = totalEggs - (dozens * 12);

        System.out.println(dozens + " dozens + " + eggs + " eggs");
    }
}
