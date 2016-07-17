import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountAllWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\W");
        List<String> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals("")) list.add(words[i]);
        }

        System.out.println(list.size());
    }
}
