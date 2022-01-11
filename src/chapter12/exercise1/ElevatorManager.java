package chapter12.exercise1;

import java.util.ArrayList;
import java.util.List;

public class ElevatorManager {
    private List<ElevatorController> controllers = new ArrayList<>();
    private SchedulerStrategy strategy;

    public ElevatorManager(int controllerCount, SchedulerStrategy strategy) {
        for (int i = 0; i < controllerCount; i++) {
            controllers.add(new ElevatorController(i));
        }
        this.strategy = strategy;
    }

    public void setStrategy(SchedulerStrategy strategy) {
        this.strategy = strategy;
    }

    protected void requestElevator(int destination, Direction direction) {
        ElevatorScheduler scheduler = SchedulerFactory.getScheduler(strategy);
        System.out.println(scheduler);

        int selectedElevatorId = scheduler.selectElevator(this, destination, direction);
        controllers.get(selectedElevatorId).gotoFloor(destination);
    }
}
