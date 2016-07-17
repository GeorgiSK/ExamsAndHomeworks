import javax.net.ssl.SSLContext;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivityTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "(\\d+)/*(\\d+)/*(\\d+)\\s(\\w+)\\s([0-9.]+)";
        TreeMap<Integer, TreeMap<String, Integer>> months = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            int day = 0;
            int month = 0;
            int year = 0;
            String name = new String();
            int distance = 0;

            if (matcher.find()) {
                day = Integer.parseInt(matcher.group(1));
                month = Integer.parseInt(matcher.group(2));
                year = Integer.parseInt(matcher.group(3));
                name = matcher.group(4);
                distance = Integer.parseInt(matcher.group(5));
            }

            if (!(months.containsKey(month))) {
                TreeMap<String, Integer> inner = new TreeMap<>();
                inner.put(name, distance);
                months.put(month, inner);
            }else {
                if (!(months.get(month).containsKey(name))) {
                    months.get(month).put(name, distance);
                }else {
                    months.get(month).put(name, months.get(month).get(name) + distance);
                }
            }
        }

        for (Map.Entry<Integer, TreeMap<String, Integer>> outerMap : months.entrySet()) {
            System.out.print(outerMap.getKey() + ": ");
            TreeMap<String, Integer> innerMap = outerMap.getValue();

            for (Map.Entry<String, Integer> entry : innerMap.entrySet()) {
                if (entry.equals(innerMap.firstEntry())) {
                    System.out.print(innerMap.firstEntry().getKey() + "(" + innerMap.firstEntry().getValue() + ")");
                }else {
                    System.out.print(", " + entry.getKey() + "(" + entry.getValue() + ")");
                }
            }
            System.out.println();
        }
    }
}
