package chapter10.practice02;

public abstract class CarOptionDecorator implements CarComponent {
    private CarComponent decoratedCar;

    public CarOptionDecorator(CarComponent decoratedCar) {
        this.decoratedCar = decoratedCar;
    }

    @Override
    public int getPrice() {
        return decoratedCar.getPrice();
    }

    @Override
    public String getCarInfo() {
        return decoratedCar.getCarInfo();
    }
}
