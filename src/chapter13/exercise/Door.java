package chapter13.exercise;

public abstract class Door {
    private DoorStatus doorStatus;

    public Door() {
        this.doorStatus = DoorStatus.CLOSED;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public boolean isOpened() {
        return doorStatus == DoorStatus.OPENED;
    }

    public void close() {
        if (doorStatus == DoorStatus.OPENED) {
            doClose();
            doorStatus = DoorStatus.CLOSED;
        }
    }

    protected abstract void doClose();

    public void open() {
        if (doorStatus == DoorStatus.CLOSED) {
            doOpen();
            doorStatus = DoorStatus.OPENED;
        }
    }

    protected abstract void doOpen();
}
