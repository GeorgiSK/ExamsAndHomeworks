import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Windows on 3/28/2016.
 */
public class Main {
    public static void main(String[] args) {
        Stream<List<String>> namesOriginalList = Stream.of(
                Arrays.asList("Petar"),
                Arrays.asList("Petar"),
                Arrays.asList("Petar"),
                Arrays.asList("Petar"),
                Arrays.asList("Petar"));

        Stream<String> flatStream = namesOriginalList
                .flatMap(strList -> strList.stream())
                .sorted();

        String[] names = {"fasf","Rosen","asd","asdasd"};

        Arrays.stream(names).sorted().limit(3).forEach(System.out::println);

        Arrays.stream(names).map(name -> name + " Petrov").forEach(System.out::println);



        Integer[] numbers = {-4, 2, 0, 12, -48, -123123};

        System.out.println(Arrays.stream(numbers).allMatch(n -> n >= 0));

        System.out.println(Arrays.stream(numbers).anyMatch(n -> n >= 0));

        List<Integer> queriedNumbers= Arrays.stream(numbers).map(n -> {
            if (n < 0) {
                return n * -1;
        }
            return n;
        }).collect(Collectors.toList());
    }
}
