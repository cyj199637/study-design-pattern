package chapter13.exercise;

public class MotorFactory {
    public static Motor createMotor(Vendor vendor) {
        switch (vendor) {
            case LG:
                return new LGMotor();
            case HYUNDAI:
                return new HyundaiMotor();
            default:
                throw new RuntimeException();
        }
    }
}
