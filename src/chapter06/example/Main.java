package chapter06.example;

public class Main {
    private static final int USER_NUM = 5;

    public static void main(String[] args) {
        UserThread[] users = new UserThread[USER_NUM];
        for (int i = 0; i < USER_NUM; i++) {
            users[i] = new UserThread((i + 1) + "-thread");
            users[i].start();
        }
    }
}
