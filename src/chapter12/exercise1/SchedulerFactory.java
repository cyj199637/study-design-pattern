package chapter12.exercise1;

import java.util.Calendar;

public class SchedulerFactory {
    public static ElevatorScheduler getScheduler(SchedulerStrategy strategy) {
        switch (strategy) {
            case THROUGHPUT:
                return ThroughputScheduler.getInstance();
            case RESPONSE_TIME:
                return ResponseTimeScheduler.getInstance();
            case DYNAMIC:
                // 현재 시간
                int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

                // 오전 -> 대기 시간 최소화, 오후 -> 엘리베이터의 처리량 최대화
                if (hour < 12) {
                    return ResponseTimeScheduler.getInstance();
                } else {
                    return ThroughputScheduler.getInstance();
                }
            default:
                throw new RuntimeException();
        }
    }
}
