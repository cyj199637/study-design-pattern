package chapter10.practice02;

public class NaviDecorator extends CarOptionDecorator {
    private int naviPrice;

    public NaviDecorator(CarComponent decoratedCar, int naviPrice) {
        super(decoratedCar);
        this.naviPrice = naviPrice;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + naviPrice;
    }

    @Override
    public String getCarInfo() {
        return super.getCarInfo() + "\n\t내비게이션 추가";
    }
}
