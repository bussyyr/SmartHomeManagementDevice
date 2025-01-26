package infrastructure.api.dto;

import java.time.LocalTime;

public class ConditionConfigInput {
    private double threshold;
    private LocalTime targetTime; ///schemada String

    public ConditionConfigInput() {}

    public ConditionConfigInput(double threshold, LocalTime targetTime) {
        this.threshold = threshold;
        this.targetTime = targetTime;
    }
}
