package chapter07.exercise;

public interface State {
    void onButtonPushed(StatePatternLight light);
    void offButtonPushed(StatePatternLight light);
}
