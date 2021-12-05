package chapter07.exercise;

public class Light {
    private static final int OFF = 0;
    private static final int ON = 1;

    private int state;

    public Light() {
        this.state = OFF;
    }

    public void onButtonPushed() {
        if (state == OFF) {
            this.state = ON;
            System.out.println("Light ON");
        } else {
            System.out.println("Nothing Happened");
        }
    }

    public void offButtonPushed() {
        if (state == ON) {
            this.state = OFF;
            System.out.println("Light OFF");
        } else {
            System.out.println("Nothing Happened");
        }
    }
}
