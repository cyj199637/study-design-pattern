package chapter12.practice2;

public abstract class CarState {
    protected Car car;

    public CarState(Car car) {
        this.car = car;
    }

    public abstract void speedUp(int targetSpeed);

    public void speedDown(int targetSpeed) {
        System.out.print("Speed: " + car.getSpeed());
        if (targetSpeed < car.getSpeed()) {
            car.setSpeed(targetSpeed);
        }

        System.out.println(" ==> " + car.getSpeed());
    }

    public abstract void engineFailureDetected();

    public abstract void engineRepaired();
}
