package customlist.implementations;

import customlist.interfaces.CustomList;

import java.util.ArrayList;

public class CustomArrayList<T extends Comparable<T>> extends ArrayList<T> implements CustomList<T> {
    public CustomArrayList() {
        super();
    }

    public void swap(int indexOne, int indexTwo){
        T firstIndexVal = super.get(indexOne);
        T secondIndexVal = super.get(indexTwo);

        this.set(indexOne, secondIndexVal);
        this.set(indexTwo, firstIndexVal);
    }
    public int countGreaterThan(T element){
        Integer count = 0;

        for (T t : this) {
            if (t.compareTo(element) > 0) count++;
        }
        return count;
    }
    public T getMax(){
        T max = super.get(0);

        for (T t : this) {
            if (t.compareTo(max) > 0) max = t;
        }

        return max;
    }
    public T getMin(){
        T min = super.get(0);

        for (T t : this) {
            if (min.compareTo(t) > 0) min = t;
        }

        return min;
    }
}
