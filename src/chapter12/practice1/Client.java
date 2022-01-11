package chapter12.practice1;

public class Client {

    public static void main(String[] args) {
        ElevatorController controller1 = new ElevatorController(1, MotorBrand.LG);
        controller1.gotoFloor(5);
        controller1.gotoFloor(3);

        ElevatorController controller2 = new ElevatorController(2, MotorBrand.HYUNDAI);
        controller2.gotoFloor(4);
        controller2.gotoFloor(6);
    }
}
