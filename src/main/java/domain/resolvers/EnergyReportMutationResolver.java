package domain.resolvers;

import infrastructure.api.dto.EnergyReportInput;
import domain.models.EnergyReport;
import domain.ports.EnergyReportService;
import infrastructure.persistence.mapper.EnergyReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnergyReportMutationResolver {
    private final EnergyReportService energyReportService;
    private final EnergyReportMapper energyReportMapper = EnergyReportMapper.INSTANCE;

    @Autowired
    public EnergyReportMutationResolver(EnergyReportService energyReportService) {
        this.energyReportService = energyReportService;
    }

    /// /Mutation
    public EnergyReport createEnergyReport(EnergyReportInput energyReportInput) {
        EnergyReport energyReport = energyReportMapper.inputToDomain(energyReportInput);
        return energyReportService.createEnergyReport(energyReport);
    }

    public boolean deleteEnergyReport(final long id) {
        return energyReportService.deleteEnergyReport(id);
    }
}
