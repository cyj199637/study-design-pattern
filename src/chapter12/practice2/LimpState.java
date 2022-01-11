package chapter12.practice2;

import java.util.Objects;

public class LimpState extends CarState {
    private static LimpState instance;
    public static final int MAX_SPEED = 60;

    private LimpState(Car car) {
        super(car);
    }

    public static LimpState getInstance(Car car) {
        if (Objects.isNull(instance)) {
            instance = new LimpState(car);
        }

        return instance;
    }

    @Override
    public void speedUp(int targetSpeed) {
        System.out.print("Speed: " + car.getSpeed());
        if (targetSpeed >= MAX_SPEED) {
            car.setSpeed(MAX_SPEED);
        }

        if ((targetSpeed < MAX_SPEED) && (targetSpeed > car.getSpeed())) {
            car.setSpeed(targetSpeed);
        }

        System.out.println(" ==> " + car.getSpeed());
    }

    @Override
    public void engineFailureDetected() {
    }

    @Override
    public void engineRepaired() {
        car.setState(CarStateFactory.getState(car));
    }
}
