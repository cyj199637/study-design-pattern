package chapter07.exercise;

// 상태 진입도 각 상태에서 처리하므로 상태 별로 분기 처리할 필요가 없다.
public class On implements State {
    private static final On INSTANCE = new On();

    private On() {}

    public static On getInstance() {
        return INSTANCE;
    }

    @Override
    public void onButtonPushed(StatePatternLight light) {
        light.setState(Sleeping.getInstance());
        System.out.println("Sleeping Light On");
    }

    @Override
    public void offButtonPushed(StatePatternLight light) {
        light.setState(Off.getInstance());
        System.out.println("Light Off");
    }
}
