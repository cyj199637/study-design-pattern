package chapter07.practice;

public class NotEnough implements DrinkInventoryState {
    private static final NotEnough INSTANCE = new NotEnough();

    private NotEnough() {}

    public static NotEnough getInstance() {
        return INSTANCE;
    }

    @Override
    public void reflect(Drink drink) {
        drink.setState(Enough.getInstance());
    }
}
