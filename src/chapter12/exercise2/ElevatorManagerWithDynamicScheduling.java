package chapter12.exercise2;

import java.util.Calendar;

public class ElevatorManagerWithDynamicScheduling extends ElevatorManager {
    public ElevatorManagerWithDynamicScheduling(int controllerCount) {
        super(controllerCount);
    }

    @Override
    protected ElevatorScheduler getScheduler() {
        // 현재 시간
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        // 오전 -> 대기 시간 최소화, 오후 -> 엘리베이터의 처리량 최대화
        if (hour < 12) {
            return ResponseTimeScheduler.getInstance();
        } else {
            return ThroughputScheduler.getInstance();
        }
    }
}
