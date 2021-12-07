package chapter07.practice;

public class Enough implements DrinkInventoryState {
    private static final Enough INSTANCE = new Enough();

    private Enough() {}

    public static Enough getInstance() {
        return INSTANCE;
    }

    @Override
    public void increaseInventory(Drink drink, int inventory) {
        int currentInventory = drink.getInventory();
        drink.setInventory(currentInventory + inventory);
    }

    @Override
    public void decreaseInventory(Drink drink) throws RuntimeException {
        int decreasedInventory = drink.getInventory() - 1;
        if (decreasedInventory < 0) {
            drink.setState(NotEnough.getInstance());
            System.out.println("재고가 부족합니다.");
            throw new RuntimeException();
        }
        drink.setInventory(decreasedInventory);
    }
}
