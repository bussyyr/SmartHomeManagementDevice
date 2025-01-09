package infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class EnergyReportEntity {

    @Column(nullable = false)
    @Id
    private long energyReportId;

    private Date date;

    @ManyToOne
    private DeviceEntity deviceEntity;

    @Column
    private double totalConsumption;

    public EnergyReportEntity() {

    }

    public EnergyReportEntity(long energyReportId, Date date, DeviceEntity deviceEntity, double totalComsumption) {
        this.energyReportId = energyReportId;
        this.date = date;
        this.deviceEntity = deviceEntity;
        this.totalConsumption = 0;
    }

    public long getEnergyReportId() {
        return energyReportId;
    }

    public void setEnergyReportId(long energyReportId) {
        this.energyReportId = energyReportId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DeviceEntity getDevice() {
        return deviceEntity;
    }

    public void setDevice(DeviceEntity deviceEntity) {
        this.deviceEntity = deviceEntity;
    }

    public double getTotalConsumption() {
        return totalConsumption;
    }

    public void setTotalConsumption(double totalConsumption) {
        this.totalConsumption = totalConsumption;
    }
}
