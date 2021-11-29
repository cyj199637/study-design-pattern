package chapter06.practice;

public class Practice02 {
    private static final int USER_NUM = 5;

    public static void main(String[] args) {
        final var users = new BuyerThread[USER_NUM];
        for (int i = 0; i < USER_NUM; i++) {
            users[i] = new BuyerThread((i + 1) + "-thread");
            users[i].start();
        }
    }
}

class TicketMachine {
    private static TicketMachine instance = new TicketMachine();
    private static final long LIMIT = 10_000L;

    private long currentTicketNumber = 0;

    private TicketMachine() {}

    public static TicketMachine getInstance() {
        return instance;
    }

    public synchronized Ticket issueTicket() {
        if (currentTicketNumber > LIMIT) {
            return null;
        }

        currentTicketNumber++;
        return new Ticket(currentTicketNumber);
    }
}

class Ticket {
    private final long serialNumber;

    public Ticket(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public long getSerialNumber() {
        return this.serialNumber;
    }

    public boolean isValidSerialNumber() {
        return this.serialNumber > 0;
    }
}

class BuyerThread extends Thread {
    private Ticket ticket;

    public BuyerThread(String name) {
        super(name);
    }

    public void run() {
        this.ticket = TicketMachine.getInstance().issueTicket();
        System.out.println(Thread.currentThread().getName() + "'s ticket number is " + ticket.getSerialNumber() + ".");
    }
}