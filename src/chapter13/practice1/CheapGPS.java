package chapter13.practice1;

public class CheapGPS extends GPS {
    @Override
    public Location findCurrentLocation() {
        System.out.println("Find current location with Cheap GPS.");
        return null;
    }
}
