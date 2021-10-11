package chapter02.example;

public class Main {
    public static void main(String[] args) {
        Pet[] pets = {new Cat(), new Parrot()};
        for (Pet pet : pets) {
            pet.talk();
        }

        A a1 = new A1();
        A1 a2 = new A1();

        a1.doIt();
        a1.doThat();
        a2.doIt();

        Person person = new Person();
        person.commute();
        person.work();
    }
}
