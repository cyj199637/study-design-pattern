package chapter12.practice2;

import java.util.Objects;

public class NormalState extends CarState {
    private static NormalState instance;

    private NormalState(Car car) {
        super(car);
    }

    public static NormalState getInstance(Car car) {
        if (Objects.isNull(instance)) {
            instance = new NormalState(car);
        }

        return instance;
    }

    @Override
    public void speedUp(int targetSpeed) {
        System.out.print("Speed: " + car.getSpeed());
        if (targetSpeed > car.getSpeed()) {
            car.setSpeed(targetSpeed);
        }

        System.out.println(" ==> " + car.getSpeed());
    }

    @Override
    public void engineFailureDetected() {
        System.out.print("Speed: " + car.getSpeed());
        car.setSpeed(LimpState.MAX_SPEED);
        System.out.println(" ==> " + car.getSpeed());
        car.setState(CarStateFactory.getState(car));
    }

    @Override
    public void engineRepaired() {
        System.out.println("Unexpected Event");
    }
}
