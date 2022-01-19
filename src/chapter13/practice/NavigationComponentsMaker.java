package chapter13.practice;

public abstract class NavigationComponentsMaker {
    public abstract GPS createGPS();
    public abstract Map createMap();
    public abstract Screen createScreen();
    public abstract PathFinder createPathFinder();
}
