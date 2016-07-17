import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CongateWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String regex = "[A-z]+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        boolean foundOne = false;
        List<String> words = new ArrayList<>();
        TreeSet<String> wordsTwo = new TreeSet<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }

        if (words.size() < 3) {
            System.out.println("No");
            foundOne = true;
        }else {
            for (int i = 0; i < words.size(); i++) {
                for (int j = 0; j < words.size(); j++) {
                    for (int k = 0; k < words.size(); k++) {
                        String a = words.get(i);
                        String b = words.get(j);
                        String c = words.get(k);

                        if ((a + b).equals(c)) {
                            wordsTwo.add(a + "|" + b + "=" + c);
                            foundOne = true;
                        }
                    }
                }
            }
        }

        if (!foundOne) System.out.println("No");
        else {
            for (String s : wordsTwo) {
                System.out.println(s);
            }
        }
    }
}
