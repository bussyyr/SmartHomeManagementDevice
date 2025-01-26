package domain.resolvers;

import domain.models.User;
import graphql.kickstart.tools.GraphQLQueryResolver;
import infrastructure.persistence.adapters.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserQueryResolver implements GraphQLQueryResolver{
    private final UserService userService;

    @Autowired
    public UserQueryResolver(UserService userService) {
        this.userService = userService;
    }

    ///Query/////////////////////////////////////////////////////////////////
    public User getUserById(final long id) {
        return userService.getUserById(id);
    }

    ///bu kadar cok get methoduna gerek var mi
    public User getUserByEmail(final String email) {
        return userService.getUserByEmail(email);
    }

    public User getUserByName(final String name) {
        return userService.getUserByName(name);
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}


