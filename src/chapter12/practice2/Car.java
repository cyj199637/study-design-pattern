package chapter12.practice2;

public class Car {
    private int speed = 0;
    private CarState state = CarStateFactory.getState(this);

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public CarState getState() {
        return state;
    }

    public void setState(CarState state) {
        this.state = state;
    }

    public void speedUp(int targetSpeed) {
        state.speedUp(targetSpeed);
    }

    public void speedDown(int targetSpeed) {
        state.speedDown(targetSpeed);
    }

    public void engineFailureDetected() {
        state.engineFailureDetected();
    }

    public void engineRepaired() {
        state.engineRepaired();
    }
}
