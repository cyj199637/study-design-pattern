package chapter07.exercise;

public class SleepingLight {
    private static final int OFF = 0;
    private static final int ON = 1;
    private static final int SLEEPING = 2;

    private int state;

    public SleepingLight() {
        this.state = OFF;
    }

    public void onButtonPushed() {
        if (state == ON) {
            this.state = SLEEPING;
            System.out.println("Sleeping Light ON");
        } else if (state == SLEEPING) {
            this.state = ON;
            System.out.println("Light ON");
        } else {
            this.state = ON;
            System.out.println("Light ON");
        }
    }

    public void offButtonPushed() {
        if (state == ON) {
            this.state = OFF;
            System.out.println("Light OFF");
        } else if (state == SLEEPING) {
            this.state = OFF;
            System.out.println("Light OFF");
        } else {
            System.out.println("Nothing Happened");
        }
    }
}
