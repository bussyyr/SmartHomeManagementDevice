package domain.ports;

import domain.models.EnergyReport;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EnergyReportService {

    EnergyReport createEnergyReport(EnergyReport report);
    boolean deleteEnergyReport(int id);

    Optional<EnergyReport> getEnergyReportsById(int id);
    Optional<EnergyReport> getEnergyReportByDate(Date date);

    List<EnergyReport> getAllEnergyReports();
}
