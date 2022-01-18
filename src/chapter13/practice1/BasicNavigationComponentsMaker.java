package chapter13.practice1;

public class BasicNavigationComponentsMaker extends NavigationComponentsMaker {
    public static BasicNavigationComponentsMaker instance = new BasicNavigationComponentsMaker();

    private BasicNavigationComponentsMaker() {}

    public static BasicNavigationComponentsMaker getInstance() {
        return instance;
    }

    @Override
    public GPS createGPS() {
        return new CheapGPS();
    }

    @Override
    public Map createMap() {
        return new SmallMap();
    }

    @Override
    public Screen createScreen() {
        return new SDScreen();
    }

    @Override
    public PathFinder createPathFinder() {
        return new SlowPathFinder();
    }
}
