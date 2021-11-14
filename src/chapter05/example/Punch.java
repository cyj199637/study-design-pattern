package chapter05.example;

public class Punch implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("I have strong punch and can attack with it");
    }
}
