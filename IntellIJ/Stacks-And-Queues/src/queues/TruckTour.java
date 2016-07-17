package queues;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TruckTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> possiblePoints = new ArrayList<>();


        int fuel = 0;

        for (int i = 0; i < n; i++) {
            boolean firstPassed = false;
            boolean secondPassed = false;
            String current = scanner.nextLine();
            int currentFuel = Integer.parseInt(current.trim().split(" ")[0]);
            fuel += currentFuel;
            int currentDistance = Integer.parseInt(current.trim().split(" ")[1]);

            for (int j = i; j < n; j++) {
                if (j + fuel >= j + 1 + currentDistance) {

                    fuel -= currentDistance;

                    if(j == n-1 && fuel > 0) {
                        firstPassed = true;
                    }
                }
            }

            for (int j = 0; j < i; j++) {
                if (j + fuel >= j + 1 + currentDistance) {

                    fuel -= currentDistance;

                    if(j == n-1 && fuel > 0) {
                        firstPassed = true;
                    }
                }
            }

            if (i <= 1 && firstPassed || firstPassed && secondPassed) {
                possiblePoints.add(i);
                break;
            }

        }

        possiblePoints.sort((a, b) -> a - b);

        System.out.println(possiblePoints.get(0));
    }
}
