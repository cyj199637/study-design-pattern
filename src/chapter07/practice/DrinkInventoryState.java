package chapter07.practice;

public interface DrinkInventoryState {
    void increaseInventory(Drink drink, int inventory);

    void decreaseInventory(Drink drink);
}
