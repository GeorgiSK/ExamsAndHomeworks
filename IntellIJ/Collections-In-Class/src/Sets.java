import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Sets {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();

        numbers.add(2);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(23);
        numbers.add(343);
        numbers.add(5456);
        numbers.add(223);
        numbers.add(67);
        numbers.add(77);
        numbers.add(2);
        numbers.add(5);

        System.out.println(numbers);

        TreeSet<Integer> numbers2 = new TreeSet<>();

        numbers2.add(2);
        numbers2.add(2);
        numbers2.add(2);
        numbers2.add(2);
        numbers2.add(3);
        numbers2.add(23);
        numbers2.add(343);
        numbers2.add(5456);
        numbers2.add(223);
        numbers2.add(67);
        numbers2.add(77);
        numbers2.add(2);
        numbers2.add(5);

        System.out.println(numbers2);

        LinkedHashSet<Integer> numbers3 = new LinkedHashSet<>();

        numbers3.add(2);
        numbers3.add(2);
        numbers3.add(2);
        numbers3.add(3);
        numbers3.add(23);
        numbers3.add(343);
        numbers3.add(5456);
        numbers3.add(223);
        numbers3.add(67);
        numbers3.add(77);
        numbers3.add(2);
        numbers3.add(5);
        System.out.println(numbers3);

    }
}
