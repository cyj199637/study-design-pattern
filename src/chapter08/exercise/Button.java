package chapter08.exercise;

public class Button {
    private Command command;

    public Button(Command command) {
        this.command = command;
    }

    public void changeCommand(Command command) {
        this.command = command;
    }

    public void pressed() {
        command.execute();
    }
}
