package chapter03.example;

import java.util.Calendar;

public class FakeTimeProvider implements TimeProvider {
    private Calendar calendar;

    public FakeTimeProvider() {
        this.calendar = Calendar.getInstance();
    }

    public FakeTimeProvider(int hours) {
        this.calendar = Calendar.getInstance();
        setHours(hours);
    }

    @Override
    public void setHours(int hours) {
        calendar.set(Calendar.HOUR_OF_DAY, hours);
    }

    @Override
    public int getTime() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
}
