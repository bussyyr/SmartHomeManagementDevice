package infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

//////mapper kullanmamiz gerekiyor mu entity -> domain arasi gecisi saglamak icin


@Entity
public class DeviceEntity {

    public enum deviceType{
        SWITCHABLE,
        ADJUSTABLE
    }

    @Column(nullable = false)
    @Id
    private long deviceId;

    @Column(nullable = false)
    private boolean status; // on/off

    @Column(nullable = false)
    private deviceType deviceType;

    //is it okay??
    @Column(nullable = false)
    private double totalConsumptionPerHour;

    @OneToMany
    private List<EnergyReportEntity> energyReportEntities;

    ///duzelt///
    @OneToMany
    private List<AutomationRuleEntity> automationRules;

    //column olarak vermemize gerek var mi
    @ManyToOne
    private RoomEntity room;

    public DeviceEntity() {

    }

    public DeviceEntity(long deviceId, deviceType deviceType, RoomEntity room) {
        this.deviceId = deviceId;
        this.status = false;
        this.deviceType = deviceType;
        this.room = room;
        this.energyReportEntities = new ArrayList<>();
        this.automationRules = new ArrayList<>();
    }

    public long getDeviceId() {
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

    public DeviceEntity.deviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceEntity.deviceType deviceType) {
        this.deviceType = deviceType;
    }

    public List<EnergyReportEntity> getEnergyReports() {
        return energyReportEntities;
    }

    public void setEnergyReports(List<EnergyReportEntity> energyReportEntities) {
        this.energyReportEntities = energyReportEntities;
    }

    public List<AutomationRuleEntity> getAutomationRules() {
        return automationRules;
    }

    public void setAutomationRules(List<AutomationRuleEntity> automationRules) {
        this.automationRules = automationRules;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }
}

