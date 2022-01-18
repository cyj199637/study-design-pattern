package chapter13.exercise;

public class ElevatorFactoryFactory {
    public static ElevatorFactory getFactory(Vendor vendor) {
        switch (vendor) {
            case LG:
                return LGElevatorFactory.getInstance();
            case HYUNDAI:
                return HyundaiElevatorFactory.getInstance();
            default:
                throw new RuntimeException();
        }
    }
}
