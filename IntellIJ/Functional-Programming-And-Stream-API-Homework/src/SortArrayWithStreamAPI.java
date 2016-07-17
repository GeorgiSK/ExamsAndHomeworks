import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortArrayWithStreamAPI {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split(" ");
        String order = scanner.nextLine();

       List<Integer> nums;

        if (order.trim().equals("Ascending")){
            nums = Arrays.stream(inputArray).map(el -> Integer.parseInt(el)).sorted((s1,s2) -> s1.compareTo(s2)).collect(Collectors.toList());
        } else {
            nums = Arrays.stream(inputArray).map(el -> Integer.parseInt(el)).sorted((s1,s2) -> s2.compareTo(s1)).collect(Collectors.toList());
        }

        nums.stream().forEach(el -> System.out.print(el + " "));
    }
}
