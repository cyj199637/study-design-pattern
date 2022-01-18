package chapter13.exercise;

public class DoorFactory {
    public static Door createDoor(Vendor vendor) {
        switch (vendor) {
            case LG:
                return new LGDoor();
            case HYUNDAI:
                return new HyundaiDoor();
            default:
                throw new RuntimeException();
        }
    }
}
