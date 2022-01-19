package chapter13.practice;

public class SlowPathFinderTestComponentsMaker extends NavigationComponentsMaker {
    public static SlowPathFinderTestComponentsMaker instance = new SlowPathFinderTestComponentsMaker();

    private SlowPathFinderTestComponentsMaker() {}

    public static SlowPathFinderTestComponentsMaker getInstance() {
        return instance;
    }

    @Override
    public GPS createGPS() {
        return new GPSSimulator();
    }

    @Override
    public Map createMap() {
        return new TestMap();
    }

    @Override
    public Screen createScreen() {
        return new TestScreen();
    }

    @Override
    public PathFinder createPathFinder() {
        return new SlowPathFinder();
    }
}
