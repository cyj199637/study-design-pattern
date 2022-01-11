package chapter12.practice1;

public class ElevatorController {
    private int id;
    private int currentFloor = 1;
    private Motor motor;

    public ElevatorController(int id, MotorBrand brand) {
        this.id = id;
        this.motor = MotorFactory.getMotor(brand);
    }

    public void changeMotor(MotorBrand brand) {
        this.motor = MotorFactory.getMotor(brand);
    }

    public void gotoFloor(int destination) {
        if (destination == currentFloor) {
            return;
        }

        if (destination > currentFloor) {
            motor.move(Direction.UP);
        } else {
            motor.move(Direction.DOWN);
        }

        System.out.println("Elevator [" + id + "] Floor: " + currentFloor);
        currentFloor = destination;
        System.out.println(" ==> " + currentFloor + " with " + motor.getClass().getName());

        motor.stop();
    }
}
