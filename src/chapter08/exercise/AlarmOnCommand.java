package chapter08.exercise;

public class AlarmOnCommand implements Command {
    private Alarm alarm;

    public AlarmOnCommand(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void execute() {
        alarm.turnOn();
    }
}
