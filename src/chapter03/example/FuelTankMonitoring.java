package chapter03.example;

public class FuelTankMonitoring {
    private CheckSystem checkSystem;
    private SignalSystem signalSystem;

    public FuelTankMonitoring(final CheckSystem checkSystem, final SignalSystem signalSystem) {
        this.checkSystem = checkSystem;
        this.signalSystem = signalSystem;
    }

    public void checkAndWarn() {
        if (checkSystem.check()) {
            signalSystem.send();
        }
    }
}
