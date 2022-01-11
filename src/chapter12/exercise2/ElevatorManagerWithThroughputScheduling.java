package chapter12.exercise2;

public class ElevatorManagerWithThroughputScheduling extends ElevatorManager {
    public ElevatorManagerWithThroughputScheduling(int controllerCount) {
        super(controllerCount);
    }

    @Override
    protected ElevatorScheduler getScheduler() {
        return ThroughputScheduler.getInstance();
    }
}
