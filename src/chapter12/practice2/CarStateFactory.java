package chapter12.practice2;

public class CarStateFactory {
    public static CarState getState(Car car) {
        CarState currentState = car.getState();

        if (currentState instanceof NormalState) {
            return LimpState.getInstance(car);
        } else {
            return NormalState.getInstance(car);
        }
    }
}
