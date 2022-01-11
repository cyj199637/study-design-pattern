package chapter12.practice1;

public class HyundaiMotor extends Motor {
    @Override
    protected void moveMotor(Direction direction) {
        System.out.println("Move Hyundai Motor " + direction);
    }
}
