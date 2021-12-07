package chapter07.practice;

import java.math.BigDecimal;

public class NoCash implements InputCashState {
    private static final NoCash INSTANCE = new NoCash();

    private NoCash() {}

    public static NoCash getInstance() {
        return INSTANCE;
    }

    @Override
    public void insertCash(VendingMachine machine, BigDecimal cash) {
        machine.setState(EnoughCash.getInstance());
        BigDecimal currentInputCash = machine.getCurrentInputCash().add(cash);
        machine.setCurrentInputCash(currentInputCash);
        System.out.println(currentInputCash.toString());
    }

    @Override
    public Drink pushButton(VendingMachine machine, int number) throws RuntimeException {
        System.out.println("돈을 넣지 않았습니다.");
        throw new RuntimeException();
    }

    @Override
    public BigDecimal returnCash(VendingMachine machine) throws RuntimeException {
        System.out.println("반환할 돈이 없습니다.");
        throw new RuntimeException();
    }
}
