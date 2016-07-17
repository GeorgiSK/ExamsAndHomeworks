package problem_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (!(input = reader.readLine()).equals("End")) {
            String[] line = input.trim().split(" ");
            Integer beersBought = Integer.parseInt(line[0]);
            Integer beersDrank = Integer.parseInt(line[1]);

            BeerCounter.buyBeer(beersBought);
            BeerCounter.drinkBeer(beersDrank);
        }

        System.out.println(BeerCounter.beerInStock + " " + BeerCounter.beerDrankCount);
    }
}

class BeerCounter {
    static Integer beerInStock = 0;
    static Integer beerDrankCount = 0;

    static void drinkBeer(int numOfBeers) {
        beerInStock -= numOfBeers;
        beerDrankCount += numOfBeers;
    }

    static void buyBeer(int numOfBeers) {
        beerInStock += numOfBeers;
    }
}
