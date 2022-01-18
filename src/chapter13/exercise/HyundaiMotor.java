package chapter13.exercise;

public class HyundaiMotor extends Motor {
    @Override
    protected void moveMotor(Direction direction) {
        System.out.println("Move Hyundai Motor " + direction);
    }
}
