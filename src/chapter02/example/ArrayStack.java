package chapter02.example;

public class ArrayStack {
    private int top;
    private int[] itemArray;
    private int stackSize;

    public ArrayStack(int stackSize) {
        this.itemArray = new int[stackSize];
        this.top = -1;
        this.stackSize = stackSize;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == this.stackSize - 1);
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Failed to insert. Array stack is full.");
            return;
        }

        itemArray[++top] = item;
        System.out.println("Success to insert item: " + item);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Failed to delete. Array stack is Empty.");
            return -1;
        }

        return itemArray[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Failed to peek. Array stack is Empty.");
            return -1;
        }

        return itemArray[top];
    }
}
