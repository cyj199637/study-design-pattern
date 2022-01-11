package chapter12.practice1;

public class LGMotor extends Motor {
    @Override
    protected void moveMotor(Direction direction) {
        System.out.println("Move LG Motor " + direction);
    }
}

