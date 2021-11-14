package chapter05.example;

public class Client {
    public static void main(String[] args) {
        final Robot taekwonV = new TaekwonV("TaekwonV");
        taekwonV.setMovingStrategy(new Walking());
        taekwonV.setAttackStrategy(new Missile());

        final Robot atom = new Atom("Atom");
        atom.setMovingStrategy(new Flying());
        atom.setAttackStrategy(new Punch());

        System.out.println("My name is " + taekwonV.getName());
        taekwonV.move();
        taekwonV.attack();

        System.out.println("My name is " + atom.getName());
        atom.move();
        atom.attack();
    }
}
