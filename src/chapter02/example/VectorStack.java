package chapter02.example;

import java.util.Vector;

public class VectorStack<String> {
    private Vector<java.lang.String> vector = new Vector<>();

    public void push(java.lang.String s) {
        vector.add(s);
    }

    public java.lang.String pop() {
        return vector.remove(vector.size() - 1);
    }

    public boolean isEmpty() {
        return vector.isEmpty();
    }

    public int size() {
        return vector.size();
    }
}
