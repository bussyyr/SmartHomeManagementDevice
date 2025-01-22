package config;

import application.resolvers.UserQueryResolver;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfig {

    @Bean
    public GraphQLSchema graphQLSchema(UserQueryResolver userQueryResolver) {
        return SchemaParser.newParser()
                .files("schema.graphqls")
                .resolvers(userQueryResolver)
                .build()
                .makeExecutableSchema();
    }
}
