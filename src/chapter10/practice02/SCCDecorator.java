package chapter10.practice02;

public class SCCDecorator extends CarOptionDecorator {
    private int sccPrice;

    public SCCDecorator(CarComponent decoratedCar, int sccPrice) {
        super(decoratedCar);
        this.sccPrice = sccPrice;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + sccPrice;
    }

    @Override
    public String getCarInfo() {
        return super.getCarInfo() + "\n\tSCC 추가";
    }
}
