package chapter03.example;

import java.util.Calendar;

public class TimeReminder {
    private static final Calendar CALENDAR = Calendar.getInstance();

    private MP3 mp3;
    private int reminderTime;

    public TimeReminder(MP3 mp3, int reminderTime) {
        this.mp3 = mp3;
        this.reminderTime = reminderTime;
    }

    public void reminder() {
        int hour = CALENDAR.get(Calendar.HOUR_OF_DAY);

        if (hour >= reminderTime) {
            mp3.playSong();
        }
    }
}
