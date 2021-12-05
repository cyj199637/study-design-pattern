package chapter07.exercise;

public class StatePatternLight {
    private State state;

    public StatePatternLight() {
        this.state = Off.getInstance();
    }

    public void onButtonPushed() {
        state.onButtonPushed(this);     // 상태 객체에 작업을 위임
    }

    public void offButtonPushed() {
        state.offButtonPushed(this);
    }

    public void setState(State state) {
        this.state = state;
    }
}
