package chapter12.practice1;

public class MotorFactory {
    public static Motor getMotor(MotorBrand brand) {
        switch (brand) {
            case LG:
                return new LGMotor();
            case HYUNDAI:
                return new HyundaiMotor();
            default:
                throw new RuntimeException();
        }
    }
}
