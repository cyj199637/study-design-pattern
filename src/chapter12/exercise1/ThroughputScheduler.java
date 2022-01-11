package chapter12.exercise1;

public class ThroughputScheduler implements ElevatorScheduler {
    private static final ThroughputScheduler scheduler = new ThroughputScheduler();

    private ThroughputScheduler() {}

    public static ThroughputScheduler getInstance() {
        return scheduler;
    }

    @Override
    public int selectElevator(ElevatorManager elevatorManager, int destination, Direction direction) {
        // 임의로 선택
        return 0;
    }
}
