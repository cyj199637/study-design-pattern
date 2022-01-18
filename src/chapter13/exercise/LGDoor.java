package chapter13.exercise;

public class LGDoor extends Door {
    @Override
    protected void doClose() {
        System.out.println("Close LG Door.");
    }

    @Override
    protected void doOpen() {
        System.out.println("Open LG Door.");
    }
}
