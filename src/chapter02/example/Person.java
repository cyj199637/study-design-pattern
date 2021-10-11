package chapter02.example;

public class Person {
    private Role role;

    public void commute() {
        role = new Driver();
        role.doSomething();
    }

    public void work() {
        role = new Worker();
        role.doSomething();
    }
}
