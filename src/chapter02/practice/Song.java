package chapter02.practice;

public class Song {
    private double price;
    private DiscountMode mode;

    public Song(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price * (1 - mode.getDiscountRate());
    }

    public DiscountMode getMode() {
        return mode;
    }

    public void applyOnSale() {
        this.mode = DiscountMode.ON_SALE;
    }

    public void applyTodayEvent() {
        this.mode = DiscountMode.TODAY_EVENT;
    }
}
