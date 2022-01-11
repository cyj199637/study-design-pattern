package chapter12.exercise1;

public class ResponseTimeScheduler implements ElevatorScheduler {
    private static final ResponseTimeScheduler scheduler = new ResponseTimeScheduler();

    private ResponseTimeScheduler() {}

    public static ResponseTimeScheduler getInstance() {
        return scheduler;
    }

    @Override
    public int selectElevator(ElevatorManager elevatorManager, int destination, Direction direction) {
        // 임의로 선택
        return 1;
    }
}
