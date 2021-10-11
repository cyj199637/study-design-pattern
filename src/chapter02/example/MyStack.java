package chapter02.example;

import java.util.ArrayList;

public class MyStack<String> {
    private ArrayList<java.lang.String> arrayList = new ArrayList<>();

    public void push(java.lang.String element) {
        arrayList.add(element);
    }

    public java.lang.String pop() {
        return arrayList.remove(arrayList.size() - 1);
    }

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    public int size() {
        return arrayList.size();
    }
}
