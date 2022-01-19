package chapter13.practice;

public class PremiumNavigationComponentsMaker extends NavigationComponentsMaker {
    public static PremiumNavigationComponentsMaker instance = new PremiumNavigationComponentsMaker();

    private PremiumNavigationComponentsMaker() {}

    public static PremiumNavigationComponentsMaker getInstance() {
        return instance;
    }

    @Override
    public GPS createGPS() {
        return new ExpensiceGPS();
    }

    @Override
    public Map createMap() {
        return new LargeMap();
    }

    @Override
    public Screen createScreen() {
        return new HDScreen();
    }

    @Override
    public PathFinder createPathFinder() {
        return new FastPathFinder();
    }
}
