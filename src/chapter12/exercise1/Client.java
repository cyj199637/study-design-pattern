package chapter12.exercise1;

public class Client {

    public static void main(String[] args) {
        ElevatorManager managerWithThroughputScheduler = new ElevatorManager(2, SchedulerStrategy.THROUGHPUT);
        managerWithThroughputScheduler.requestElevator(10, Direction.UP);

        ElevatorManager managerWithResponseTimeScheduler = new ElevatorManager(2, SchedulerStrategy.RESPONSE_TIME);
        managerWithResponseTimeScheduler.requestElevator(10, Direction.UP);

        ElevatorManager managerWithDynamicScheduler = new ElevatorManager(2, SchedulerStrategy.DYNAMIC);
        managerWithDynamicScheduler.requestElevator(10, Direction.UP);
    }
}
