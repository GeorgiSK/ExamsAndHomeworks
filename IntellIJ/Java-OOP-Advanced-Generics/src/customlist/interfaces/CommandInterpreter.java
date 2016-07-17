package customlist.interfaces;

public interface CommandInterpreter<T extends Comparable<T>> {
    void add(T element);
    void remove(Integer index);
    boolean contains(T element);
    void swap(Integer indexOne, Integer indexTwo);
    Integer greater(T element);
    Integer max();
    Integer min();
    void print();
    void startReading();
    void endReading();

}
