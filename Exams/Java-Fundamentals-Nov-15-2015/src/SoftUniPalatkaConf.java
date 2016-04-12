import java.util.LinkedHashMap;
        import java.util.Map;
        import java.util.Scanner;

public class SoftUniPalatkaConf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPeople = Integer.parseInt(scanner.nextLine());
        int numOfLines = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> tents = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> food = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> rooms = new LinkedHashMap<>();
        int totalBeds = 0;
        int foodReserve = 0;

        for (int i = 0; i < numOfLines; i++) {
            String[] line = scanner.nextLine().trim().split("\\s+");

            if (line[0].trim().toLowerCase().equals("tents")){
                if (tents.containsKey(line[2])){
                    int newValue = tents.get(line[2]) + Integer.parseInt(line[1]);
                    tents.put(line[2], newValue);
                }else {
                    tents.put(line[2], Integer.parseInt(line[1]));
                }
            }else  if (line[0].trim().toLowerCase().equals("rooms")) {
                if (rooms.containsKey(line[2])){
                    int newValue = rooms.get(line[2]) + Integer.parseInt(line[1]);
                    rooms.put(line[2], newValue);
                }else {
                    rooms.put(line[2], Integer.parseInt(line[1]));
                }
            }else if (line[0].trim().toLowerCase().equals("food")){
                if (food.containsKey(line[2])){
                    int newValue = food.get(line[2]) + Integer.parseInt(line[1]);
                    food.put(line[2], newValue);
                }else {
                    food.put(line[2], Integer.parseInt(line[1]));
                }
            }
        }


        for (Map.Entry<String, Integer> entry : rooms.entrySet()) {
            if (entry.getKey().toLowerCase().equals("single")) totalBeds += entry.getValue();
            else if (entry.getKey().toLowerCase().equals("double")) totalBeds += entry.getValue() * 2;
            else if (entry.getKey().toLowerCase().equals("triple")) totalBeds += entry.getValue() * 3;
        }

        for (Map.Entry<String, Integer> entry : tents.entrySet()) {
            if (entry.getKey().toLowerCase().equals("normal")) totalBeds += entry.getValue() * 2;
            else if (entry.getKey().toLowerCase().equals("firstclass")) totalBeds += entry.getValue() * 3;
        }

        for (Map.Entry<String, Integer> entry : food.entrySet()) {
            if (entry.getKey().toLowerCase().equals("musaka")) foodReserve += entry.getValue() * 2;
        }

        if (numOfPeople > totalBeds) {
            System.out.println("Some people are freezing cold. Beds needed: " + (numOfPeople - totalBeds));
        }else {
            System.out.println("Everyone is happy and sleeping well. Beds left: " + (totalBeds - numOfPeople));
        }

        if (numOfPeople > foodReserve) {
            System.out.println("People are starving. Meals needed: " + (numOfPeople - foodReserve));
        }else {
            System.out.println("Nobody left hungry. Meals left: " + (foodReserve - numOfPeople));
        }
    }
}
