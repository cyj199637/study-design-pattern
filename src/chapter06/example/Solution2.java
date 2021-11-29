package chapter06.example;

public class Solution2 {
    private static final int USER_NUM = 5;

    public static void main(String[] args) {
        final var users = new Solution2UserThread[USER_NUM];
        for (int i = 0; i < USER_NUM; i++) {
            users[i] = new Solution2UserThread((i + 1) + "-thread");
            users[i].start();
        }
    }
}

class Solution2UserThread extends Thread {
    public Solution2UserThread(String name) {
        super(name);
    }

    public void run() {
        final var printer = Solution2Printer.getPrinter();
        printer.print(Thread.currentThread().getName() + " print using " + printer.toString() + ".");
    }
}

class Solution2Printer {
    private static Solution2Printer printer = null;

    private int counter = 0;

    private Solution2Printer() {}

    public synchronized static Solution2Printer getPrinter() {  // 메서드 동기화
        if (printer == null) {
            printer = new Solution2Printer();
        }
        return printer;
    }

    public void print(String str) {
        synchronized (this) {   // 오직 하나의 스레드만 접근 허용
            counter++;
            System.out.println(str + " / current count: " + counter);
        }
    }
}
