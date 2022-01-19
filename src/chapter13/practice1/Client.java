package chapter13.practice1;

public class Client {
    public static void main(String[] args) {
        NavigationComponentsMaker maker = TestComponentsMakerFactory.getMaker(SlowPathFinder.class);

        GPS gps = maker.createGPS();
        Screen screen = maker.createScreen();
        PathFinder pathFinder = maker.createPathFinder();

        Map map = maker.createMap();
        screen.drawMap(map);

        Location from = gps.findCurrentLocation();
        Location to = gps.findCurrentLocation();

        pathFinder.findPath(from, to);
    }
}
