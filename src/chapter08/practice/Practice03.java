package chapter08.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Practice03 {
    public static void main(String[] args) {

    }
}

class ElevatorManager {
    private List<ElevatorController> controllers = new ArrayList<>();

    public ElevatorManager() {}

    public void addController(ElevatorController controller) {
        controllers.add(controller);
    }

    public void requestElevator(int destination) {
        final var selected = selectElevator(destination);
        selected.goToFloor(destination);
    }

    private ElevatorController selectElevator(int destination) {
        return controllers.stream()
            .min(Comparator.comparing(x -> Math.abs(destination - x.getCurrentFloor())))
            .get();
    }
}

class ElevatorController {
    private int id;
    private int currentFloor;

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public ElevatorController(int id) {
        this.id = id;
    }

    public void goToFloor(int destination) {
        this.currentFloor = destination;
    }
}

class ElevatorButton {
    private ElevatorCommand command;

    public ElevatorButton(ElevatorCommand command) {
        this.command = command;
    }

    public void pressed() {
        command.execute();
    }
}

interface ElevatorCommand {
    void execute();
}

// ElevatorManager에 의해 선택된 엘리베이터를 현재 층으로 호출
class ElevatorRequestCommand implements ElevatorCommand {
    private ElevatorManager manager;

    private int destination;

    public ElevatorRequestCommand(ElevatorManager manager, int destination) {
        this.manager = manager;
        this.destination = destination;
    }

    @Override
    public void execute() {
        manager.requestElevator(destination);
    }
}

// 엘리베이터 내부에서 이동하려는 층의 버튼을 눌렀을 때 목적지 층으로 이동
class DestinationSelectionCommand implements ElevatorCommand {
    private ElevatorController controller;

    private int destination;

    public DestinationSelectionCommand(ElevatorController controller, int destination) {
        this.controller = controller;
        this.destination = destination;
    }

    @Override
    public void execute() {
        controller.goToFloor(destination);
    }
}

enum Direction {
    UP,
    DOWN;
}