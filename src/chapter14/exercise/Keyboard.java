package chapter14.exercise;

public class Keyboard implements ComputerComponent {
    private int price;
    private int power;

    public Keyboard(int price, int power) {
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
