package chapter02.practice;

import java.util.LinkedList;

public class Queue<String> {
    private LinkedList<java.lang.String> linkedList = new LinkedList<>();

    public boolean addQueue(java.lang.String element) {
        return linkedList.add(element);
    }

    public java.lang.String removeQueue() {
        return linkedList.remove();
    }

    public java.lang.String peekQueue() {
        return linkedList.peek();
    }
}
