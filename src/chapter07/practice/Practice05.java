package chapter07.practice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Practice05 {
    public static void main(String[] args) {

    }
}

class VendingMachine {
    private InputCashState state = NoCash.getInstance();
    private BigDecimal currentInputCash = BigDecimal.ZERO;
    private Map<Integer, Drink> drinks = new HashMap<>();

    public BigDecimal getCurrentInputCash() {
        return currentInputCash;
    }

    public Map<Integer, Drink> getDrinks() {
        return drinks;
    }

    public void setCurrentInputCash(BigDecimal currentInputCash) {
        this.currentInputCash = currentInputCash;
    }

    public void setState(InputCashState state) {
        this.state = state;
    }

    public void insertCash(BigDecimal cash) {
        state.insertCash(this, cash);
    }

    public Drink pushButton(int number) throws RuntimeException {
        try {
            return state.pushButton(this, number);
        } catch (RuntimeException e) {
            returnCash();
            throw e;
        }
    }

    public BigDecimal returnCash() {
        return state.returnCash(this);
    }

    public void changeDrinkPriceAndInventory(int number, BigDecimal price, int inventory) {
        Drink drink = drinks.get(number);
        drink.setPrice(price);
        drink.increaseInventory(inventory);
    }
}

class Drink {
    private BigDecimal price;
    private int inventory = 0;
    private DrinkInventoryState state = NotEnough.getInstance();

    public Drink(BigDecimal price, int inventory) {
        this.price = price;
        this.inventory = inventory;
    }

    public void setState(DrinkInventoryState state) {
        this.state = state;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getInventory() {
        return inventory;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void increaseInventory(int inventory) {
        state.increaseInventory(this, inventory);
    }

    public void decreaseInventory() throws RuntimeException {
        state.decreaseInventory(this);
    }
}