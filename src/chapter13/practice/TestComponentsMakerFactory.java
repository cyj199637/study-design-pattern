package chapter13.practice;

public class TestComponentsMakerFactory {
    public static NavigationComponentsMaker getMaker(Class target) {
        switch (target.getSimpleName()) {
            case "SlowPathFinder":
                return SlowPathFinderTestComponentsMaker.getInstance();
            default:
                throw new RuntimeException();
        }
    }
}
