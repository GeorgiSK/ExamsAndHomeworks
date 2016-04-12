import java.util.*;

public class Nuts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, LinkedHashMap<String, Integer>> companies = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            String order = input[1];
            int amount = Integer.parseInt(input[2].split("[kg]")[0]);

            if (companies.size() < 1) {
                companies.put(name, new LinkedHashMap<>());
                LinkedHashMap<String, Integer> innerMap = companies.get(name);
                innerMap.put(order, amount);
            }else {
                if (!companies.containsKey(name)) {
                    companies.put(name, new LinkedHashMap<>());
                    LinkedHashMap<String, Integer> innerMap = companies.get(name);
                    innerMap.put(order, amount);
                }else {
                    LinkedHashMap<String, Integer> innerMap = companies.get(name);

                    if (!innerMap.containsKey(order)) {
                        innerMap.put(order, amount);
                    }else {
                        int newAmount = innerMap.get(order) + amount;
                        innerMap.put(order, newAmount);
                    }
                }
            }
        }

        for (String s : companies.keySet()) {
            System.out.print(s + ": ");
            LinkedHashMap<String, Integer> innerMap = companies.get(s);
            int iterator = 0;
            for (Map.Entry<String, Integer> entry : innerMap.entrySet()) {
                if (iterator == 0) {
                    System.out.print(entry.getKey() + "-" + entry.getValue() + "kg");
                }else {
                    System.out.print(", " + entry.getKey() + "-" + entry.getValue() + "kg");
                }
                iterator++;
            }
            System.out.println();
        }
    }
}

