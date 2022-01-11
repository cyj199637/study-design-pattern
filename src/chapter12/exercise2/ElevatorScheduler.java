package chapter12.exercise2;

import chapter12.exercise1.Direction;

public interface ElevatorScheduler {
    int selectElevator(ElevatorManager elevatorManager, int destination, Direction direction);
}
