package genericbox;

public class Box<T> {
    private T var;

    public Box(T var) {
        this.var = var;
    }

    @Override
    public String toString() {
        return this.var.getClass().getName();
    }

    public T getVar() {
        return var;
    }
}
