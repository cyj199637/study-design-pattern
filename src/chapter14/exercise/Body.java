package chapter14.exercise;

public class Body implements ComputerComponent {
    private int price;
    private int power;

    public Body(int price, int power) {
        this.price = price;
        this.power = power;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getPower() {
        return power;
    }
}
