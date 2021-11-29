package chapter06.practice;

import java.util.List;
import java.util.Random;
import javax.naming.ServiceUnavailableException;

public class Practice04 {
    private static final int THREAD_NUM = 10;

    public static void main(String[] args) {
        final var user = new UserThread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i++) {
            user[i] = new UserThread((i + 1) + "-Thread");
            user[i].start();
        }
    }
}

class Printer {
    private boolean available = true;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void print(String name) {
        try {
            Thread.sleep(1);
            System.out.println(name + " is using " + this.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        setAvailable(true);
    }
}

class PrinterManager {
    private static PrinterManager instance = new PrinterManager();
    private final List<Printer> printers = List.of(
        new Printer(), new Printer(), new Printer()
    );

    private PrinterManager() {}

    public static PrinterManager getInstance() {
        return instance;
    }

    public Printer getPrinter() throws ServiceUnavailableException {
        for (var printer : printers) {
            if (printer.isAvailable()) {
                printer.setAvailable(false);
                return printer;
            }
        }

        throw new ServiceUnavailableException("현재 이용가능한 프린터가 없습니다.");
    }
}

class UserThread extends Thread {
    private Printer printer;

    public UserThread(String name) {
        super(name);
    }

    public void run() {
        final var manager = PrinterManager.getInstance();
        try {
            printer = manager.getPrinter();
            printer.print(getName());
        } catch (ServiceUnavailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
