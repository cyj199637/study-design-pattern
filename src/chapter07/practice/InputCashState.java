package chapter07.practice;

import java.math.BigDecimal;

public interface InputCashState {
    void insertCash(VendingMachine machine, BigDecimal cash);

    Drink pushButton(VendingMachine machine, int number);

    BigDecimal returnCash(VendingMachine machine);
}
