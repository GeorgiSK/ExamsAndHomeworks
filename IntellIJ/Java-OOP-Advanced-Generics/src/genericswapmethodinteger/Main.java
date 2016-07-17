package genericswapmethodinteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }

        String[] indexes = reader.readLine().trim().split(" ");
        swapIndexes(list, Integer.parseInt(indexes[0]), Integer.parseInt(indexes[1]));

        for (Integer integer : list) {
            Box currentBox = new Box(integer);
            System.out.println(currentBox.toString() + ": " + currentBox.getVar());
        }

    }

    public static <T> List swapIndexes(List<T> list, int firstIndex, int secondIndex) {
        T firstIndexValue = list.get(firstIndex);
        T secondIndexValue = list.get(secondIndex);
        list.set(firstIndex, secondIndexValue);
        list.set(secondIndex, firstIndexValue);

        return list;
    }

}
