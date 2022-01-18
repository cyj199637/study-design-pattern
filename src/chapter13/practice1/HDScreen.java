package chapter13.practice1;

public class HDScreen extends Screen {
    @Override
    public void drawMap(Map map) {
        System.out.println("Draw map " + map.getClass().getName() + " on HD Screen.");
    }
}
