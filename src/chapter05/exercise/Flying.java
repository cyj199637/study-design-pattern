package chapter05.exercise;

public class Flying implements MovingStrategy {
    @Override
    public void move() {
        System.out.println("I can fly.");
    }
}
