package chapter03.example;

public class TimeReminderAnswer {
    private TimeProvider timeProvider;
    private MP3 mp3 = new MP3();

    public void setTimeProvider(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public void reminder() {
        int hours = timeProvider.getTime();
        if (hours >= 22) {
            mp3.playSong();
        }
    }
}
