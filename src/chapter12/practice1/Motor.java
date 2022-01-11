package chapter12.practice1;

public abstract class Motor {
    private MotorStatus motorStatus;

    public Motor() {
        this.motorStatus = MotorStatus.STOPPED;
    }

    // 템플릿 메서드
    public void move(Direction direction) {
        if (motorStatus == MotorStatus.MOVING) {
            return;
        }

        moveMotor(direction);
        this.motorStatus = MotorStatus.MOVING;
    }

    // primitive / hook 메서드
    protected abstract void moveMotor(Direction direction);

    public void stop() {
        this.motorStatus = MotorStatus.STOPPED;
    }
}
