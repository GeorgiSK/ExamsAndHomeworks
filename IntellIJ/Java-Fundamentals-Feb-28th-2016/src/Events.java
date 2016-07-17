import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Events {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^#([A-z]+):\\s*@([A-z]+)\\s*(([0-1][0-9]|2[0-3]):([0-5][0-9]))$";
        String line;
        int numOfLines = Integer.parseInt(scanner.nextLine());

        TreeMap<String, TreeMap<String, List<String>>> locations = new TreeMap<>();

        for (int i = 0; i < numOfLines; i++) {
            line = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String person = matcher.group(1);
                String location = matcher.group(2);
                String time = matcher.group(3);

                if (!(locations.containsKey(location))){
                    TreeMap<String, List<String>> innerMap = new TreeMap<>();
                    ArrayList<String> list = new ArrayList<>();
                    list.add(time);
                    innerMap.put(person, list);

                    locations.put(location, innerMap);
                }else {
                    TreeMap<String, List<String>> innerMap = locations.get(location);
                    ArrayList<String> list = new ArrayList<>();
                    list.add(time);

                    if (!(innerMap.containsKey(person))) {
                        innerMap.put(person, list);
                        locations.get(location).put(person, list);
                    }else {
                        locations.get(location).get(person).add(time);
                    }
                }
            }
        }

        List<String> finalLocations = Arrays.asList(scanner.nextLine().trim().split("[ ,]+"));

        for (Map.Entry<String, TreeMap<String, List<String>>> mapEntry : locations.entrySet()) {
            String location = mapEntry.getKey();
            int counter = 1;
            TreeMap<String, List<String>> innerMap = mapEntry.getValue();
            if (finalLocations.stream().filter(o -> o.equals(location)).findFirst().isPresent()) {
                System.out.println(location + ":");

                for (Map.Entry<String, List<String>> entry : innerMap.entrySet()) {
                    List<String> list = entry.getValue();
                    list.sort((a, b) -> {
                        if (a.split(":")[0].equals(b.split(":")[0])){
                            return Integer.parseInt(a.split(":")[1]) - Integer.parseInt(b.split(":")[1]);
                        }else {
                            return Integer.parseInt(a.split(":")[0]) - Integer.parseInt(b.split(":")[0]);
                        }
                    });

                    System.out.println(counter++ + ". " + entry.getKey() + " -> " + list.toString().replace('[', '\0').replace(']', '\0'));
                }
            }
        }
    }
}