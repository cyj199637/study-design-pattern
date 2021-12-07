package chapter07.practice;

import java.math.BigDecimal;

public class EnoughCash implements InputCashState {
    private static final EnoughCash INSTANCE = new EnoughCash();

    private EnoughCash() {}

    public static EnoughCash getInstance() {
        return INSTANCE;
    }

    @Override
    public void insertCash(VendingMachine machine, BigDecimal cash) {
        BigDecimal currentInputCash = machine.getCurrentInputCash().add(cash);
        machine.setCurrentInputCash(currentInputCash);
        System.out.println(currentInputCash.toString());
    }

    @Override
    public Drink pushButton(VendingMachine machine, int number) throws RuntimeException {
        Drink drink = machine.getDrinks().get(number);
        BigDecimal drinkPrice = drink.getPrice();
        BigDecimal currentInputCash = machine.getCurrentInputCash();

        if (currentInputCash.compareTo(drinkPrice) < 0) {
            System.out.println("돈이 부족합니다.");
            throw new RuntimeException();
        }

        try {
            drink.decreaseInventory();
        } catch (RuntimeException e) {
            throw e;
        }

        BigDecimal balance = currentInputCash.subtract(drinkPrice);
        if (balance.equals(BigDecimal.ZERO)) {
            machine.setState(NoCash.getInstance());
        }

        machine.setCurrentInputCash(balance);
        return drink;
    }

    @Override
    public BigDecimal returnCash(VendingMachine machine) {
        machine.setState(NoCash.getInstance());
        return machine.getCurrentInputCash();
    }
}
