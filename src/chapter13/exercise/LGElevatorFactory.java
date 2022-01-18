package chapter13.exercise;

public class LGElevatorFactory extends ElevatorFactory {
    private static LGElevatorFactory instance = new LGElevatorFactory();

    private LGElevatorFactory() {}

    public static LGElevatorFactory getInstance() {
        return instance;
    }

    @Override
    public Motor createMotor() {
        return new LGMotor();
    }

    @Override
    public Door createDoor() {
        return new LGDoor();
    }
}
