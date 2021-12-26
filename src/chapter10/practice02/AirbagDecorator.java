package chapter10.practice02;

public class AirbagDecorator extends CarOptionDecorator {
    private int airbagPrice;

    public AirbagDecorator(CarComponent carComponent, int airbagPrice) {
        super(carComponent);
        this.airbagPrice = airbagPrice;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + airbagPrice;
    }

    @Override
    public String getCarInfo() {
        return super.getCarInfo() + "\n\t에어백 추가";
    }
}
