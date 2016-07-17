package genericcountmethoddoubles;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {
    private T var;

    public Box(T var) {
        this.var = var;
    }

    @Override
    public String toString() {
        return this.var.getClass().getName();
    }

    public T getValue() {
        return var;
    }

    @Override
    public int compareTo(Box<T> o) {
        return var.compareTo(o.getValue());
    }
}
