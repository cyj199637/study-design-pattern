package chapter08.practice;

public class Practice02 {
    public static void main(String[] args) {
        ImprovedTV tv = new ImprovedTV();
        PowerCommand powerCommand = new PowerCommand(tv);
        MuteCommand muteCommand = new MuteCommand(tv);

        ImprovedRemoteController controller = new ImprovedRemoteController(muteCommand, powerCommand);

        controller.button1Pressed();
        controller.button2Pressed();
        controller.button1Pressed();
        controller.button1Pressed();
        controller.button2Pressed();
        controller.button1Pressed();
    }
}

class ImprovedTV {
    private boolean powerOn = false;
    private boolean muteOn = false;

    public void power() {
        powerOn =! powerOn;

        if (powerOn) {
            System.out.println("Power On.");
        } else {
            System.out.println("Power Off.");
        }
    }

    public void mute() {
        if (!powerOn) {
            return;
        }

        muteOn =! muteOn;

        if (muteOn) {
            System.out.println("Mute On.");
        } else {
            System.out.println("Mute Off.");
        }
    }
}

class ImprovedRemoteController {
    private Command button1Command;
    private Command button2command;

    public ImprovedRemoteController(Command command1, Command command2) {
        this.button1Command = command1;
        this.button2command = command2;
    }

    public void button1Pressed() {
        button1Command.execute();
    }

    public void button2Pressed() {
        button2command.execute();
    }
}

interface Command {
    void execute();
}

class PowerCommand implements Command {
    private ImprovedTV tv;

    public PowerCommand(ImprovedTV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.power();
    }
}

class MuteCommand implements Command {
    private ImprovedTV tv;

    public MuteCommand(ImprovedTV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.mute();
    }
}