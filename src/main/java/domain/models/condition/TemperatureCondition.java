package domain.models.condition;

public class TemperatureCondition implements Condition{

    private double currentTemperature;
    private double threshold;

    @Override
    public boolean evaluate() {
        return currentTemperature > threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }
}
