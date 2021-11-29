package chapter06.practice;

public class Practice01 {
    public static void main(String[] args) {

    }
}

class Singleton {
//    private Singleton instance = null;
    private static Singleton instance = new Singleton();

//    public Singleton() {}
    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }

    public void doSomething() {}
}
