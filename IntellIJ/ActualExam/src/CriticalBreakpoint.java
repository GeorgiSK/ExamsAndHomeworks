import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CriticalBreakpoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        List<BigInteger> criticalRatios = new ArrayList<>();
        List<List<String>> lines = new ArrayList<>();
        boolean isCriticalPresent = false;
        BigInteger criticalBreakpoint;
        BigInteger lineIndex = new BigInteger("0");

        while (!(input = scanner.nextLine()).equals("Break it.")) {
            String[] coordinates = input.split("\\s+");
            List<String> curr = Arrays.asList(coordinates);
            lines.add(curr);

            BigInteger x1 = new BigInteger(coordinates[0]);
            BigInteger y1 = new BigInteger(coordinates[1]);
            BigInteger x2 = new BigInteger(coordinates[2]);
            BigInteger y2 = new BigInteger(coordinates[3]);

            BigInteger criticalRation = ((x2.add(y2)).subtract(x1.add(y1))).abs();
            criticalRatios.add(criticalRation);
        }

        for (int i = 0; i < criticalRatios.size(); i++) {
            if (criticalRatios.get(i).equals(new BigInteger("0"))) {
                isCriticalPresent = true;
                break;
            }
            if (lineIndex.equals(new BigInteger("0"))) {
                lineIndex = criticalRatios.get(i);
            }

            for (int j = 0; j < criticalRatios.size(); j++) {
                if (i != j) {
                    if (!(criticalRatios.get(i).equals(criticalRatios.get(j)))) {
                        isCriticalPresent = false;
                    }
                }
            }
        }

        String size = Integer.toString(criticalRatios.size());

        criticalBreakpoint = (lineIndex.pow(Integer.parseInt(size))).mod(new BigInteger(size));

        if (isCriticalPresent) {

            for (List<String> line : lines) {
                System.out.println("Line: " + line);
            }
            System.out.println("Critical Breakpoint: " + criticalBreakpoint);
        }else {
            System.out.println("Critical breakpoint does not exist.");
        }
    }
}
