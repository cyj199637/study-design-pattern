package chapter07.exercise;

public class Off implements State {
    private static final Off INSTANCE = new Off();

    private Off() {}

    public static Off getInstance() {
        return INSTANCE;
    }

    @Override
    public void onButtonPushed(StatePatternLight light) {
        light.setState(On.getInstance());
        System.out.println("Light On");
    }

    @Override
    public void offButtonPushed(StatePatternLight light) {
        System.out.println("Nothing Happened");
    }
}
