package chapter02.example;

public class StackClient {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push(20);
        System.out.println(stack.peek());

        ArrayListStack listStack = new ArrayListStack(5);
        listStack.push(10);
        listStack.push(20);
        listStack.push(30);
        listStack.push(40);
        listStack.push(50);
        listStack.push(60);
        System.out.println(listStack.isFull());
        System.out.println(listStack.peek());
    }
}
