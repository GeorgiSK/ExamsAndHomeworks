import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLongs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;

        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        while (!(input = scanner.nextLine()).equals("end")) {
            String[] line = input.trim().split(" ");
            String ip = line[0].substring(3);
            String username = line[2].substring(5);


            if (users.size() == 0) {
                users.put(username, new LinkedHashMap<>());
                users.get(username).put(ip, 1);
            }else {
                if (!users.containsKey(username)) {
                    users.put(username, new LinkedHashMap<>());
                    users.get(username).put(ip, 1);
                }else {
                    if (!users.get(username).containsKey(ip)){
                        users.get(username).put(ip, 1);
                    }else {
                        int newCount = users.get(username).get(ip) + 1;
                        users.get(username).put(ip, newCount);
                    }

                }
            }
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> outerMap : users.entrySet()) {
            System.out.println(outerMap.getKey() + ":");

            LinkedHashMap<String, Integer> innerMap = outerMap.getValue();
            int iter = 0;
            for (Map.Entry<String, Integer> entry : innerMap.entrySet()) {
                if (iter == innerMap.size() - 1) {
                    System.out.print(entry.getKey() + " => " + entry.getValue() + ".\n");
                }else {
                    System.out.print(entry.getKey() + " => " + entry.getValue() + ", ");
                }
                iter++;
            }
        }
    }
}
