import java.util.*;

public class CardsFrequencies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //This section saves user input and modifies it
        String[] array = scanner.nextLine().split(" ");
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].replaceAll("[^a-zA-Z0-9]", "");
        }
        //This var is used to count occurrences of a card
        int count = 0;
        //LinkedHashMap to save cards with occurrence percentages
        LinkedHashMap<String, Double> input = new LinkedHashMap<>();
        //LinkedHashSet to save cards without repetition
        LinkedHashSet<String> output = new LinkedHashSet<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i].equals(array[j])) count++;
            }
            double percentage = (count / (double)array.length) * 100;
            input.put(array[i], percentage);
            output.add(array[i]);
            count = 0;
        }

        for (String s : output) {
            //System.out.println(s + " -> " + input.get(s) + "%");
            System.out.printf("%s -> %.2f%s\n", s, input.get(s), "%");
        }
    }
}
