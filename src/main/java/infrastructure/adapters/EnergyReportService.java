package infrastructure.adapters;

import infrastructure.persistence.entities.EnergyReportEntity;
import infrastructure.persistence.repositories.EnergyReportRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EnergyReportService {
    private final EnergyReportRepository energyReportRepository;

    @Autowired
    public EnergyReportService(EnergyReportRepository energyReportRepository) {
        this.energyReportRepository = energyReportRepository;
    }

    public EnergyReportEntity createEnergyReport(EnergyReportEntity energyReport) {
        return energyReportRepository.save(energyReport);
    }

    public boolean deleteEnergyReport(long id) {
        if(energyReportRepository.existsById(id)){
            energyReportRepository.deleteById(id);
            return true;
        }else{
            throw new EntityNotFoundException("Energy Report with id " + id + " not found!");
        }
    }

    public Optional<EnergyReportEntity> getEnergyReportById(long id) {
        return energyReportRepository.findById(id);
    }

    public Optional<EnergyReportEntity> getEnergyReportByDate(Date date) {
        return energyReportRepository.findByDate(date);
    }

    public List<EnergyReportEntity> getAllEnergyReports() {
        return energyReportRepository.findAll();
    }
}
