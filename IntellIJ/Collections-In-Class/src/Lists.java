import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Windows on 3/23/2016.
 */
public class Lists {
    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();
        numberList.add(1);
        numberList.add(5);
        doubleList.add(3.14);
        doubleList.add(7.24);
        doubleList.remove(7.24);
        //Removes the first number 5 of the list
        numberList.remove(new Integer(5));
        //removes the second index of the list
        numberList.remove(2);


    }
}
