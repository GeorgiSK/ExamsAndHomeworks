import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SumCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> line = Arrays.asList(scanner.nextLine().replaceAll("K", "14").replaceAll("Q", "13")
                .replaceAll("J", "12").replaceAll("A", "15").split("\\D{1,3}"));
        int sum = 0;
        if (line.size() == 1) sum += Integer.parseInt(line.get(line.size() - 1));
        else {
            for (int i = 1; i < line.size() - 1; i++) {
                if (line.get(i).equals(line.get(i - 1)) || line.get(i).equals(line.get(i + 1)))
                    sum += Integer.parseInt(line.get(i)) * 2;
                else sum += Integer.parseInt(line.get(i));
            }

            if (line.get(0).equals(line.get(1))) sum += Integer.parseInt(line.get(0)) * 2;
            else sum += Integer.parseInt(line.get(0));
            if (line.get(line.size() - 1).equals(line.get(line.size() - 2)))
                sum += Integer.parseInt(line.get(line.size() - 1)) * 2;
            else sum += Integer.parseInt(line.get(line.size() - 1));
        }
        System.out.println(sum);
    }
}
