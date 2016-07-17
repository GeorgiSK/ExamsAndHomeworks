import java.util.*;

public class MostFrequentWord {
    public static void main(String[] args) {
        //Creating a scanner for user input
        Scanner scanner = new Scanner(System.in);

        //Saving user input in a variable
        String input = scanner.nextLine();
        //splitting the variable in an array by a few delimiters
        String[] elements = input.toLowerCase().replaceAll("(^[^a-z]*)|([^a-z]*$)", "").split("[^a-z]+");
        //Saving all elements in a list
        List<String> resultList = Arrays.asList(elements);
        //A few variable to keep track of things
        int currentFrequency = 0;
        String currentWord = new String();
        int bestFrequency = 0;
        String bestWord = new String();
        //A tree map to save all best frequency relations
        TreeMap<String, Integer> relations = new TreeMap<>();

        //The first loop iterates through the whole list
        for (int i = 0; i < resultList.size(); i++) {
            //The second loop iterates only from the current index to the last occurrence of the element in the current index
            for (int j = i; j <= resultList.lastIndexOf(resultList.get(i)); j++) {
                //If its finds a copy of the element in the current index it increases the frequency and sets the current word to the current iteration
                if(resultList.get(j).equals(resultList.get(i))) {
                    currentFrequency++;
                    currentWord = resultList.get(i);
                }
            }

            //If the current frequency is higher than the best after the current iteration
            // the TreeMap is cleared and the best elements is added
            if (currentFrequency > bestFrequency) {
                relations.clear();
                relations.put(currentWord, currentFrequency);
                //If they are equal the element is added but the map is not cleared
            }else if (currentFrequency == bestFrequency) {
                relations.put(currentWord, currentFrequency);
            }

            //Here the same check is executed again to set the tracking variables with appropriate values
            if (currentFrequency >= bestFrequency) {
                bestFrequency = currentFrequency;
                bestWord = currentWord;
            }

            currentFrequency = 0;
        }

        //Here the map gets printed with the appropriate formatting
        for (Map.Entry keyValuePair : relations.entrySet()) {
            System.out.println(keyValuePair.getKey() + " -> " + keyValuePair.getValue());
        }
    }
}
