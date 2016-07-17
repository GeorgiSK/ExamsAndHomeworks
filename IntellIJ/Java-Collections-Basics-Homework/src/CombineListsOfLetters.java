import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombineListsOfLetters {
    public static void main(String[] args) {
        //Creating a scanner for user input
        Scanner scanner = new Scanner(System.in);

        String[] lineOne = scanner.nextLine().split(" ");
        String[] lineTwo = scanner.nextLine().split(" ");

        List<String> list = new ArrayList<>();
        List<String> secondLine = new ArrayList<>();

        //Here we transfer lineOne in the list
        for (String s : lineOne) {
            list.add(s);
        }

        //Here we add elements to the secondLine list if they are not present in the list
        for (String s : lineTwo) {
            if (!list.contains(s)) secondLine.add(s);
        }

        //Here we combine the lists
        list.addAll(secondLine);

        System.out.println(list);
    }
}
