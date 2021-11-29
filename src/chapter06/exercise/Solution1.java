package chapter06.exercise;

public class Solution1 {
    private static final int USER_NUM = 5;

    public static void main(String[] args) {
        final var users = new Solution1UserThread[USER_NUM];
        for (int i = 0; i < USER_NUM; i++) {
            users[i] = new Solution1UserThread((i + 1) + "-thread");
            users[i].start();
        }
    }
}

class Solution1UserThread extends Thread {
    public Solution1UserThread(String name) {
        super(name);
    }

    public void run() {
        final var printer = Solution1Printer.getPrinter();
        printer.print(Thread.currentThread().getName() + " print using " + printer.toString() + ".");
    }
}

class Solution1Printer {
    // 정적 변수에 인스턴스를 만들어 바로 초기화
    private static Solution1Printer printer = new Solution1Printer();

    private int counter = 0;

    private Solution1Printer() {}

    public static Solution1Printer getPrinter() {
        return printer;
    }

    public void print(String str) {
        counter++;
        System.out.println(str + " / current count: " + counter);
    }
}
