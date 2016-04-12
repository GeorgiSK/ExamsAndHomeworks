import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, TreeMap<Integer, TreeSet<String>>> users = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] currentUser = scanner.nextLine().split(" "); //A string with all the needed values separated
            if (!users.containsKey(currentUser[1])) { //If the outer TreeMap already contains the user skip the code below
                users.put(currentUser[1], new TreeMap());//If not add the new user and the inner treemap that has a size of 1 and holds the time and a Set of all IP's
                if (users.get(currentUser[1]).isEmpty()) {//If the inner map's Tree set is empty
                    users.get(currentUser[1]).put(0, new TreeSet<>());//Add one
                }
                TreeMap<Integer, TreeSet<String>> innerMap = users.get(currentUser[1]); //This var represents the inner TreeMap
                TreeSet<String> innerSet = innerMap.firstEntry().getValue();//This var represents the inner TreeSet with the IP's
                innerSet.add(currentUser[0]);//Here we add the current IP to the inner set
                innerMap.put(innerMap.firstEntry().getKey() + Integer.parseInt(currentUser[2]), innerSet);//Then we compute the duration and add it with the set to the inner map
                innerMap.remove(innerMap.firstEntry().getKey());//After that the old entry of the innerMap gets removed
            }else {//This code will get executed if the TreeMap already contains the current user and it is partially the same as the one above
                TreeMap<Integer, TreeSet<String>> innerMap = users.get(currentUser[1]);
                TreeSet<String> innerSet = innerMap.firstEntry().getValue();
                innerSet.add(currentUser[0]);
                innerMap.put(innerMap.firstEntry().getKey() + Integer.parseInt(currentUser[2]), innerSet);
                innerMap.remove(innerMap.firstEntry().getKey());
            }
        }

        for (Map.Entry<String, TreeMap<Integer, TreeSet<String>>> usersVar : users.entrySet()) {
            System.out.print(usersVar.getKey() + ": ");//Print the user and a :

            TreeMap<Integer, TreeSet<String>> innerMap = usersVar.getValue();//This var represents the inner map

            for (Map.Entry<Integer, TreeSet<String>> innerMapVar : innerMap.entrySet()) {//Here we iterate through the inner map
                TreeSet<String> innerSet = innerMapVar.getValue();//This var represents the set of ip's
                System.out.print(innerMapVar.getKey() + " " + innerSet + "\n");//And here we print the innerMap key (The duration) followed by the whole inner set
            }
        }
    }
}
