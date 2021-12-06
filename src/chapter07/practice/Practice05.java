package chapter07.practice;

import java.math.BigDecimal;
import java.util.Map;

public class Practice05 {
    public static void main(String[] args) {

    }
}

class VendingMachine {
    private State state;
    private BigDecimal balance;
    private Map<Integer, Drink> drinks;

    public void insertMoney(BigDecimal money) {
        this.balance = balance.add(money);
        System.out.println(money);
    }

    public Drink pushButton(Integer number, BigDecimal money) throws Exception {
        Drink drink = drinks.get(number);
        try {
            drink.decreaseInventory();
        } catch (Exception e) {
            System.out.println("재고가 부족합니다.");
            throw e;
        }


    }

    public BigDecimal returnMoney() {
        return
    }
}

class Drink {
    private BigDecimal price;
    private int inventory = 0;
    private DrinkInventoryState state = NotEnough.getInstance();

    public void setState(DrinkInventoryState state) {
        this.state = state;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void increaseInventory(int inventory) {
        state.reflect(this);
        this.inventory += inventory;
    }

    public void decreaseInventory() throws Exception {
        if (inventory <= 0) {
            state.reflect(this);
            throw new Exception();
        }

        --this.inventory;
    }
}