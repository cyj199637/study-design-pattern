package chapter06.exercise;

public class Printer {
    private static Printer printer = null;

    private int counter = 0;

    private Printer() {}

    public static Printer getPrinter() {
        if (printer == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            printer = new Printer();
        }
        return printer;
    }

    public void print(String str) {
        counter++;
        System.out.println(str + " / current count: " + counter);
    }
}
