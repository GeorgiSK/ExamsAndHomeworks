import java.util.ArrayList;
        import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class BiggestThreePrimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> primes = new ArrayList<>();
        ArrayList<Integer> finalPrimes = new ArrayList<>();
        String line = scanner.nextLine();
        String regex = "\\d+|-\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            int num = Integer.parseInt(matcher.group());
            if (isPrime(num)) primes.add(num);
        }

        for (int i = 0; i < primes.size(); i++) {
            if (!(finalPrimes.contains(primes.get(i)))) {
                finalPrimes.add(primes.get(i));
            }
        }

        finalPrimes.sort((a, b) -> b - a);

        if (finalPrimes.size() < 3) {
            System.out.println("No");
        }else {
            System.out.println((finalPrimes.get(0) + finalPrimes.get(1) + finalPrimes.get(2)));
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
