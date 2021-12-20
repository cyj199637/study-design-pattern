package chapter09.practice;

import java.util.ArrayList;
import java.util.List;

public class Practice01ObserverPattern {

}

abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
}

class BatteryWithObserver extends Subject {
    private int level = 100;

    public int getLevel() {
        return level;
    }

    public void consume(int amount) {
        level -= amount;
        super.notifyObservers();
    }
}

interface Observer {
    void update();
}

class BatteryLevelDisplayWithObserver implements Observer {
    private Battery battery;

    public BatteryLevelDisplayWithObserver(Battery battery) {
        this.battery = battery;
    }

    @Override
    public void update() {
        int level = battery.getLevel();
        System.out.println("Level: " + level);
    }
}

class LowBatteryWarningWithObserver implements Observer {
    private static final int LOW_BATTERY = 30;
    private Battery battery;

    public LowBatteryWarningWithObserver(Battery battery) {
        this.battery = battery;
    }

    @Override
    public void update() {
        int level = battery.getLevel();
        if (level < LOW_BATTERY) {
            System.out.println("<Warning> Low Battery: " + level + " Compared with " + LOW_BATTERY);
        }
    }
}
