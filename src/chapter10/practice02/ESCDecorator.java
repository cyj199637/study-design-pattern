package chapter10.practice02;

public class ESCDecorator extends CarOptionDecorator {
    private int escPrice;

    public ESCDecorator(CarComponent decoratedCar, int escPrice) {
        super(decoratedCar);
        this.escPrice = escPrice;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + escPrice;
    }

    @Override
    public String getCarInfo() {
        return super.getCarInfo() + "\n\tESC 추가";
    }
}
