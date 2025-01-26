package domain.resolvers;

import domain.models.EnergyReport;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import infrastructure.persistence.adapters.EnergyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class EnergyReportQueryResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    private final EnergyReportService energyReportService;

    @Autowired
    public EnergyReportQueryResolver(EnergyReportService energyReportService) {
        this.energyReportService = energyReportService;
    }

    /// /Query
    public EnergyReport getEnergyReportById(final long id) {
        return energyReportService.getEnergyReportById(id);
    }

    public EnergyReport getEnergyReportByDate(final Date date) {
        return energyReportService.getEnergyReportByDate(date);
    }

    public List<EnergyReport> getAllEnergyReports() {
        return energyReportService.getAllEnergyReports();
    }


}
