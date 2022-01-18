package chapter13.exercise;

public abstract class Motor {
    private MotorStatus motorStatus;
    private Door door;

    public Motor() {
        this.motorStatus = MotorStatus.STOPPED;
    }

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    // 템플릿 메서드
    public void move(Direction direction) {
        if (door.isOpened()) {
            door.close();
        }

        if (motorStatus == MotorStatus.STOPPED) {
            moveMotor(direction);
            this.motorStatus = MotorStatus.MOVING;
        }
    }

    // primitive / hook 메서드
    protected abstract void moveMotor(Direction direction);

    public void stop() {
        this.motorStatus = MotorStatus.STOPPED;
    }
}
