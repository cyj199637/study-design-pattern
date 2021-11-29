package chapter05.exercise;

public class Walking implements MovingStrategy {
    @Override
    public void move() {
        System.out.println("I can only walk.");
    }
}
