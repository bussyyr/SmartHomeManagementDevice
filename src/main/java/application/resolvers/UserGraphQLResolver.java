package application.resolvers;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import infrastructure.adapters.UserService;
import infrastructure.persistence.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserGraphQLResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    private final UserService userService;

    @Autowired
    public UserGraphQLResolver(UserService userService) {
        this.userService = userService;
    }

    ///Query/////////////////////////////////////////////////////////////////
    public UserEntity getUserById(final long id) {
        return userService.getUserById(id).orElseGet(null);
    }

    ///bu kadar cok get methoduna gerek var mi
    public UserEntity getUserByEmail(final String email) {
        return userService.getUserByEmail(email).orElseGet(null);
    }

    public UserEntity getUserByName(final String name) {
        return userService.getUserByName(name).orElseGet(null);
    }

    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    ///Mutations/////////////////////////////////////////////////////////////////
    public UserEntity createUser(final String name, final String email, final String password) {
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        return userService.createUser(user);
    }

    /// ici user entity olmamali
    public UserEntity updateUser(final long id, final UserEntity user) {
        return userService.updateUser(id, user);
    }

    public boolean deleteUser(final long id) {
        return userService.deleteUser(id);
    }
}


