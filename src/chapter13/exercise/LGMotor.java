package chapter13.exercise;

public class LGMotor extends Motor {
    @Override
    protected void moveMotor(Direction direction) {
        System.out.println("Move LG Motor " + direction);
    }
}

