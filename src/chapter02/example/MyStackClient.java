package chapter02.example;

public class MyStackClient {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push("a");
        myStack.push("b");
        myStack.push("c");

        // myStack.set(0, "d");    // 허용되지 않아야 하는 코드
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
