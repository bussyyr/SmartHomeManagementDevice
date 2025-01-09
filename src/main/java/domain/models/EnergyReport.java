package domain.models;

import domain.models.device.Device;

import java.time.LocalDate;

public class EnergyReport {
    private int energyReportId;
    private LocalDate date;
    private Device device;
    private double totalConsumption;

    public EnergyReport(int energyReportId, Device device, double totalConsumption) {
        this.energyReportId = energyReportId;
        this.date = LocalDate.now();
        this.device = device;
        this.totalConsumption = totalConsumption;
    }

    public double dailyTotalConsumption(){
        return device.getTotalConsumptionPerHour() * device.getDailyConsumption();
    }

    public int getEnergyReportId() {
        return energyReportId;
    }

    public void setEnergyReportId(int energyReportId) {
        this.energyReportId = energyReportId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public double getTotalConsumption() {
        return totalConsumption;
    }

    public void setTotalConsumption(double totalConsumption) {
        this.totalConsumption = totalConsumption;
    }
}
