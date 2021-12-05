package chapter07.exercise;

public class Sleeping implements State {
    private static final Sleeping INSTANCE = new Sleeping();

    private Sleeping() {}

    public static Sleeping getInstance() {
        return INSTANCE;
    }

    @Override
    public void onButtonPushed(StatePatternLight light) {
        light.setState(On.getInstance());
        System.out.println("Light On");
    }

    @Override
    public void offButtonPushed(StatePatternLight light) {
        light.setState(Off.getInstance());
        System.out.println("Light Off");
    }
}
