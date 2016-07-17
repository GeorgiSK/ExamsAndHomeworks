package customlist.implementations;

import customlist.interfaces.CommandInterpreter;

public class CommandInterpreterImpl<T extends Comparable<T>> implements CommandInterpreter<T> {
    private CustomArrayList<T> operationList;

    public CommandInterpreterImpl(CustomArrayList<T> operationList) {
        this.operationList = operationList;
    }

    @Override
    public void add(T element) {

    }

    @Override
    public void remove(Integer index) {

    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public void swap(Integer indexOne, Integer indexTwo) {

    }

    @Override
    public Integer greater(T element) {
        return null;
    }

    @Override
    public Integer max() {
        return null;
    }

    @Override
    public Integer min() {
        return null;
    }

    @Override
    public void print() {

    }

    @Override
    public void startReading() {

    }

    @Override
    public void endReading() {

    }
}
