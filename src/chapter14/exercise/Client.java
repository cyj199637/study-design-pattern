package chapter14.exercise;

public class Client {

    public static void main(String[] args) {
        Keyboard keyboard = new Keyboard(10, 5);
        Body body = new Body(70, 100);
        Monitor monitor = new Monitor(30, 20);
        Speaker speaker = new Speaker(10, 10);

        Computer computer = new Computer();
        computer.addComponent(keyboard);
        computer.addComponent(body);
        computer.addComponent(monitor);
        computer.addComponent(speaker);

        System.out.println("Computer Power: " + computer.getPower() + "W");
        System.out.println("Computer Price: " + computer.getPrice() + "만 원");
    }
}
