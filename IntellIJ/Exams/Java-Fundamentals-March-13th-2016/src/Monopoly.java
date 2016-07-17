import java.util.Scanner;

public class Monopoly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();
        int money = 50;
        int numOfHotels = 0;
        int currentIteration = 0;
        int totalIterations = r * c;

        for (int i = 0; i < r; i++) {
            char[] line = scanner.nextLine().toCharArray();
            if (i % 2 == 0) {
                for (int j = 0; j < c; j++) {
                    if (line[j] == 'J') {
                        money += numOfHotels * 20;
                        totalIterations += 2;
                        System.out.println("Gone to jail at turn " + currentIteration + ".");
                    }else if (line[j] == 'H') {
                        numOfHotels++;
                        System.out.println("Bought a hotel for " + money + ". Total hotels: " + numOfHotels + ".");
                        money = 0;
                    }else if(line[j] == 'S') {
                        int moneyToSpend = (i + 1) * (j + 1);
                        System.out.println("Spent " + moneyToSpend + " money at the shop.");
                        if (moneyToSpend >= money) money = 0;
                        else money -= moneyToSpend;
                    }
                    currentIteration++;
                    money += numOfHotels * 10;
                }
            }else {
                for (int j = c - 1; j >= 0; j--) {
                    if (line[j] == 'J') {
                        money += numOfHotels * 20;
                        totalIterations += 2;
                        System.out.println("Gone to jail at turn " + currentIteration + ".");
                    }else if (line[j] == 'H') {
                        numOfHotels++;
                        System.out.println("Bought a hotel for " + money + ". Total hotels: " + numOfHotels + ".");
                        money = 0;
                    }else if(line[j] == 'S') {
                        int moneyToSpend = (i + 1) * (j + 1);
                        System.out.println("Spent " + moneyToSpend + " money at the shop.");
                        if (moneyToSpend > money) money = 0;
                        else money -= moneyToSpend;
                    }
                    currentIteration++;
                    money += numOfHotels * 10;
                }
            }
        }

        System.out.println("Turns " + totalIterations);
        System.out.println("Money " + money);
    }

}
