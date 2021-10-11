package chapter02.example;

import java.util.ArrayList;

public class ArrayListStack {
    private ArrayList<Integer> items;
    private int stackSize;

    public ArrayListStack(int stackSize) {
        this.items = new ArrayList<>(stackSize);
        this.stackSize = stackSize;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public boolean isFull() {
        return items.size() == stackSize;
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Failed to insert. ArrayList stack is full.");
            return;
        }

        items.add(item);
        System.out.println("Success to insert item: " + item);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Failed to delete. ArrayList stack is Empty.");
            return -1;
        }

        return items.remove(items.size()-1);
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Failed to peek. ArrayList stack is Empty.");
            return -1;
        }

        return items.get(items.size() - 1);
    }
}
