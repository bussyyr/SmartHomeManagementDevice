package domain.models.device;

import domain.models.AutomationRule;
import domain.models.Room;
import domain.models.EnergyReport;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Device {

    public enum deviceType{
        SWITCHABLE,
        ADJUSTABLE
    }

    private int deviceId;
    private boolean status;
    private deviceType deviceType;
    private double totalConsumptionPerHour;
    private LocalTime lastTurnOnTime;
    private double dailyConsumption;
    private List<EnergyReport> energyReports;
    private List<AutomationRule> automationRules;
    private Room room;

    public Device(int deviceId, deviceType deviceType, double totalConsumptionPerHour, Room room) {
        this.deviceId = deviceId;
        this.status = false;
        this.deviceType = deviceType;
        this.totalConsumptionPerHour = totalConsumptionPerHour;
        this.lastTurnOnTime = null;
        this.dailyConsumption = 0;
        this.energyReports = new ArrayList<>();
        this.automationRules = new ArrayList<>();
        this.room = room;
    }

    //what if we turn on a device mehrere times in a day???
    public void turnOn(){
        this.status = true;
        this.lastTurnOnTime = LocalTime.now();
    }

    public void turnOff(){
        this.status = true;
        if (lastTurnOnTime != null) {
            LocalTime now = LocalTime.now();
            Duration duration = Duration.between(lastTurnOnTime, now);
            double hours = duration.toHours() + duration.toMinutesPart() / 60.0;

            dailyConsumption += hours;
        }
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Device.deviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Device.deviceType deviceType) {
        this.deviceType = deviceType;
    }

    public double getTotalConsumptionPerHour() {
        return totalConsumptionPerHour;
    }

    public void setTotalConsumptionPerHour(double totalConsumptionPerHour) {
        this.totalConsumptionPerHour = totalConsumptionPerHour;
    }

    public LocalTime getLastTurnOnTime() {
        return lastTurnOnTime;
    }

    public void setLastTurnOnTime(LocalTime lastTurnOnTime) {
        this.lastTurnOnTime = lastTurnOnTime;
    }

    public double getDailyConsumption() {
        return dailyConsumption;
    }

    public void setDailyConsumption(double dailyConsumption) {
        this.dailyConsumption = dailyConsumption;
    }

    public List<EnergyReport> getEnergyReports() {
        return energyReports;
    }

    public void setEnergyReports(List<EnergyReport> energyReports) {
        this.energyReports = energyReports;
    }

    public List<AutomationRule> getAutomationRules() {
        return automationRules;
    }

    public void setAutomationRules(List<AutomationRule> automationRules) {
        this.automationRules = automationRules;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
