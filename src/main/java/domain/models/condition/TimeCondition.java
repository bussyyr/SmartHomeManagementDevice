package domain.models.condition;

import java.time.LocalTime;

public class TimeCondition implements Condition {
    private LocalTime targetTime;

    public TimeCondition(LocalTime targetTime) {
        this.targetTime = targetTime;
    }

    @Override
    public boolean evaluate() {
        LocalTime now = LocalTime.now();
        return now.isAfter(targetTime);
    }

    public LocalTime getTargetTime() {
        return targetTime;
    }

    public void setTargetTime(LocalTime targetTime) {
        this.targetTime = targetTime;
    }
}
