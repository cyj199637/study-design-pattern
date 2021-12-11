package chapter08.exercise;

public class Client {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        Alarm alarm = new Alarm();

        LampOnCommand lampOnCommand = new LampOnCommand(lamp);
        AlarmOnCommand alarmOnCommand = new AlarmOnCommand(alarm);

        Button button = new Button(lampOnCommand);
        button.pressed();
        button.changeCommand(alarmOnCommand);
        button.pressed();
    }
}
