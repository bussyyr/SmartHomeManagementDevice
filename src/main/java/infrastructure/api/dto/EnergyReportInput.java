package infrastructure.api.dto;

import java.util.Date;

public class EnergyReportInput {
    private Long deviceId;
    private Date date;
    private double totalConsumption;

    public EnergyReportInput() {}

    public EnergyReportInput(Long deviceId, Date date, double totalConsumption) {
        this.deviceId = deviceId;
        this.date = date;
        this.totalConsumption = totalConsumption;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalConsumption() {
        return totalConsumption;
    }

    public void setTotalConsumption(double totalConsumption) {
        this.totalConsumption = totalConsumption;
    }
}
