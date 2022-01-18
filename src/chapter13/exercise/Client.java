package chapter13.exercise;

public class Client {
    public static void main(String[] args) {
        ElevatorFactory factory = ElevatorFactoryFactory.getFactory(Vendor.LG);

        Door door = factory.createDoor();
        Motor motor = factory.createMotor();
        motor.setDoor(door);

        door.open();
        motor.move(Direction.UP);
    }
}
