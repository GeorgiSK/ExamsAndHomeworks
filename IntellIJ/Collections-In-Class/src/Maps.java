import java.util.*;

/**
 * Created by Windows on 3/23/2016.
 */
public class Maps {
    public static void main(String[] args) {
        HashMap<String, Double> grades = new HashMap<>();

        grades.put("Pesho", 6.0);
        grades.put("Minka", 4.5);
        grades.put("Penka", 6.5);
        grades.put("Stamat", 2.0);
        grades.put("Stamat", 4.0);

        System.out.println(grades);

        System.out.println(grades.keySet());

        for (String key : grades.keySet()) {
            System.out.println(grades.get(key));
        }

        System.out.println(grades.values());

        for (Double value : grades.values()) {
            System.out.println("the value is: " + value);
        }

        for (Map.Entry keyValuePair : grades.entrySet()) {
            System.out.println("The value fot [" + keyValuePair.getKey() + "] is: " + keyValuePair.getValue());
        }


        //For the exam!
        HashMap<String, TreeMap<String, ArrayList<Double>>> students = new HashMap<>();



    }
}
