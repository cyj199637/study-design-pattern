package chapter12.exercise2;

import chapter12.exercise1.Direction;
import chapter12.exercise1.SchedulerFactory;
import chapter12.exercise1.SchedulerStrategy;
import java.util.ArrayList;
import java.util.List;

public abstract class ElevatorManager {
    private List<ElevatorController> controllers = new ArrayList<>();

    public ElevatorManager(int controllerCount) {
        for (int i = 0; i < controllerCount; i++) {
            controllers.add(new ElevatorController(i));
        }
    }

    // template method
    protected void requestElevator(int destination, Direction direction) {
        ElevatorScheduler scheduler = getScheduler();
        System.out.println(scheduler);

        int selectedElevatorId = scheduler.selectElevator(this, destination, direction);
        controllers.get(selectedElevatorId).gotoFloor(destination);
    }

    // primitive method -> factory method
    protected abstract ElevatorScheduler getScheduler();
}
