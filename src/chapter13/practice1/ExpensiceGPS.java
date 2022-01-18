package chapter13.practice1;

public class ExpensiceGPS extends GPS {
    @Override
    public Location findCurrentLocation() {
        System.out.println("Find current location with Expensive GPS.");
        return null;
    }
}
