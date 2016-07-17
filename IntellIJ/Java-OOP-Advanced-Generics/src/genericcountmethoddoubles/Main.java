package genericcountmethoddoubles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());
        int count = 0;
        List<Box<Double>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Box<>(Double.parseDouble(reader.readLine())));
        }

        count = getBiggerElementsCountInList(list, new Box<>(Double.parseDouble(reader.readLine())));

        System.out.println(count);

    }

    public static <T extends Comparable> Integer getBiggerElementsCountInList(List<T> list, T element) {
        Integer count = 0;

        for (T t : list) {
            if (t.compareTo(element) > 0) count++;
        }

        return count;
    }

}
