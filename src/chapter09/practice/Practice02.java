package chapter09.practice;

import java.util.ArrayList;
import java.util.List;

public class Practice02 {
    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController();

        ElevatorDisplay elevatorDisplay = new ElevatorDisplay(controller);
        VoiceNotice voiceNotice = new VoiceNotice(controller);
        FloorDisplay floorDisplay = new FloorDisplay(controller);
        ControlRoomDisplay controlRoomDisplay = new ControlRoomDisplay(controller);

        controller.attach(elevatorDisplay);
        controller.attach(voiceNotice);
        controller.attach(floorDisplay);
        controller.attach(controlRoomDisplay);

        controller.move(5);
        controller.move(10);
    }
}

abstract class Practice02Subject {
    private List<Practice02Observer> observers = new ArrayList<>();

    public void attach(Practice02Observer observer) {
        observers.add(observer);
    }

    public void detach(Practice02Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Practice02Observer o : observers) {
            o.update();
        }
    }
}

class ElevatorController extends Practice02Subject {
    private int currentFloor = 1;

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void move(int destination) {
        this.currentFloor = destination;
        super.notifyObservers();
    }
}

interface Practice02Observer {
    void update();
}

class ElevatorDisplay implements Practice02Observer {
    private ElevatorController controller;

    public ElevatorDisplay(ElevatorController controller) {
        this.controller = controller;
    }

    @Override
    public void update() {
        System.out.println("You are at " + controller.getCurrentFloor() + "F");
    }
}

class VoiceNotice implements Practice02Observer {
    private ElevatorController controller;

    public VoiceNotice(ElevatorController controller) {
        this.controller = controller;
    }

    @Override
    public void update() {
        System.out.println("You arrived at " + controller.getCurrentFloor() + "F");
    }
}

class FloorDisplay implements Practice02Observer {
    private ElevatorController controller;

    public FloorDisplay(ElevatorController controller) {
        this.controller = controller;
    }

    @Override
    public void update() {
        System.out.println("Elevator is at " + controller.getCurrentFloor() + "F");
    }
}

class ControlRoomDisplay implements Practice02Observer {
    private ElevatorController controller;

    public ControlRoomDisplay(ElevatorController controller) {
        this.controller = controller;
    }

    @Override
    public void update() {
        System.out.println(controller.toString() + " Elevator is at " + controller.getCurrentFloor() + "F");
    }
}