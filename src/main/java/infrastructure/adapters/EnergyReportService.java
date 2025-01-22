package infrastructure.adapters;

import domain.models.EnergyReport;
import infrastructure.persistence.entities.EnergyReportEntity;
import infrastructure.persistence.repositories.EnergyReportRepository;
import jakarta.persistence.EntityNotFoundException;
import mapper.EnergyReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnergyReportService {
    private final EnergyReportRepository energyReportRepository;
    private final EnergyReportMapper energyReportMapper = EnergyReportMapper.INSTANCE;

    @Autowired
    public EnergyReportService(EnergyReportRepository energyReportRepository) {
        this.energyReportRepository = energyReportRepository;
    }

    public EnergyReport createEnergyReport(EnergyReport energyReport) {
        EnergyReportEntity entity = energyReportMapper.domainToEntity(energyReport);
        EnergyReportEntity savedEntity = energyReportRepository.save(entity);
        return energyReportMapper.entityToDomain(savedEntity);
    }

    public boolean deleteEnergyReport(long id) {
        if(energyReportRepository.existsById(id)){
            energyReportRepository.deleteById(id);
            return true;
        }else{
            throw new EntityNotFoundException("Energy Report with id " + id + " not found!");
        }
    }

    public EnergyReport getEnergyReportById(long id) {
        return energyReportRepository.findById(id)
                .map(energyReportMapper::entityToDomain)
                .orElseThrow(() -> new EntityNotFoundException("Energy Report not found!"));
    }

    public EnergyReport getEnergyReportByDate(Date date) {
        return energyReportRepository.findByDate(date)
                .map(energyReportMapper::entityToDomain)
                .orElseThrow(() -> new EntityNotFoundException("Energy Report not found!"));
    }

    public List<EnergyReport> getAllEnergyReports() {
        return energyReportRepository.findAll()
                .stream()
                .map(energyReportMapper::entityToDomain)
                .collect(Collectors.toList());
    }
}
