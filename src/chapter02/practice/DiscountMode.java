package chapter02.practice;

public enum DiscountMode {
    ON_SALE(0.1),
    TODAY_EVENT(0.3);

    DiscountMode(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    private final double discountRate;
}
