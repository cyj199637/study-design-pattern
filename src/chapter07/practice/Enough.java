package chapter07.practice;

public class Enough implements DrinkInventoryState {
    private static final Enough INSTANCE = new Enough();

    private Enough() {}

    public static Enough getInstance() {
        return INSTANCE;
    }

    @Override
    public void reflect(Drink drink) {
        drink.setState(NotEnough.getInstance());
    }
}
