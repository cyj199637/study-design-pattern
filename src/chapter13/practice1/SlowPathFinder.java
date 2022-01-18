package chapter13.practice1;

public class SlowPathFinder extends PathFinder {
    @Override
    public Path findPath(Location from, Location to) {
        System.out.println("Find path with Slow Path Finder.");
        return null;
    }
}
