package chapter01.example;

public abstract class HomeAppliance {
    private Integer serialNo;
    private String manufacturer;
    private Integer year;

    public abstract void turnOn();

    public abstract void turnOff();
}
