package customlist.interfaces;

public interface CustomList<T extends Comparable<T>> {
    void swap(int index1, int index2);
    int countGreaterThan(T element);
    T getMax();
    T getMin();
}
