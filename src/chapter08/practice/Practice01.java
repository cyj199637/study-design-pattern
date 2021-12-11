package chapter08.practice;

public class Practice01 {
    public static void main(String[] args) {
        TV tv = new TV();
        RemoteController controller = new RemoteController(tv);

        controller.button1Pressed();
        controller.button2Pressed();

        controller.button1Pressed();
        controller.button2Pressed();
    }
}

class TV {
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

class RemoteController {
    private TV tv;

    public RemoteController(TV tv) {
        this.tv = tv;
    }

    public void button1Pressed() {
        tv.power();
    }

    public void button2Pressed() {
        tv.mute();
    }
}