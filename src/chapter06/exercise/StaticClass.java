package chapter06.exercise;

public class StaticClass {
    private static final int USER_NUM = 5;

    public static void main(String[] args) {
        final var users = new StaticUserThread[USER_NUM];
        for (int i = 0; i < USER_NUM; i++) {
            users[i] = new StaticUserThread((i + 1) + "-thread");
            users[i].start();
        }
    }
}

class StaticUserThread extends Thread {
    public StaticUserThread(String name) {
        super(name);
    }

    public void run() {
        StaticPrinter.print(Thread.currentThread().getName() + " print using " + ".");
    }
}

class StaticPrinter {
    private static int counter = 0;

    public synchronized static void print(String str) { // 메서드 동기화
        counter++;
        System.out.println(str + " / current count: " + counter);
    }
}
