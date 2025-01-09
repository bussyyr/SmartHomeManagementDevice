package application.resolvers;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import infrastructure.adapters.EnergyReportService;
import infrastructure.persistence.entities.EnergyReportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class EnergyReportGraphQLResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    private final EnergyReportService energyReportService;

    @Autowired
    public EnergyReportGraphQLResolver(EnergyReportService energyReportService) {
        this.energyReportService = energyReportService;
    }

    /// /Query
    public EnergyReportEntity getEnergyReportById(final long id) {
        return energyReportService.getEnergyReportById(id).orElseGet(null);
    }

    public EnergyReportEntity getEnergyReportByDate(final Date date) {
        return energyReportService.getEnergyReportByDate(date).orElseGet(null);
    }

    public List<EnergyReportEntity> getAllEnergyReports() {
        return energyReportService.getAllEnergyReports();
    }

    /// /Mutation
    public EnergyReportEntity createEnergyReport(final EnergyReportEntity energyReportEntity) {
        return energyReportService.createEnergyReport(energyReportEntity);
    }

    public boolean deleteEnergyReport(final long id) {
        return energyReportService.deleteEnergyReport(id);
    }
}
