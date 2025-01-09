package config;

import application.resolvers.UserGraphQLResolver;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfig {

    @Bean
    public GraphQLSchema graphQLSchema(UserGraphQLResolver userGraphQLResolver) {
        return SchemaParser.newParser()
                .files("schema.graphqls")
                .resolvers(userGraphQLResolver)
                .build()
                .makeExecutableSchema();
    }
}
