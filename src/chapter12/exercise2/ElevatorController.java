package chapter12.exercise2;

public class ElevatorController {
    private int id;
    private int currentFloor;

    public ElevatorController(int id) {
        this.id = id;
        this.currentFloor = 1;
    }

    public void gotoFloor(int destination) {
        System.out.println("Elevator [" + id + "] Floor: " + currentFloor);
        currentFloor = destination;
        System.out.println(" ==> " + currentFloor);
    }
}
