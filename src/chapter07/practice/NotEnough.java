package chapter07.practice;

public class NotEnough implements DrinkInventoryState {
    private static final NotEnough INSTANCE = new NotEnough();

    private NotEnough() {}

    public static NotEnough getInstance() {
        return INSTANCE;
    }

    @Override
    public void increaseInventory(Drink drink, int inventory) {
        drink.setState(Enough.getInstance());
        int currentInventory = drink.getInventory();
        drink.setInventory(currentInventory + inventory);
    }

    @Override
    public void decreaseInventory(Drink drink) throws RuntimeException {
        System.out.println("재고가 부족합니다.");
        throw new RuntimeException();
    }
}
