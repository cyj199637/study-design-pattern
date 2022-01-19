package chapter13.practice;

public class NavigationComponentsMakerFactory {
    public static NavigationComponentsMaker getMaker(Option option) {
        switch (option) {
            case BASIC:
                return BasicNavigationComponentsMaker.getInstance();
            case PREMIUM:
                return PremiumNavigationComponentsMaker.getInstance();
            default:
                throw new RuntimeException();
        }
    }
}
