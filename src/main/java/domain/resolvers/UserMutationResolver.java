package domain.resolvers;

import infrastructure.api.dto.UserInput;
import domain.models.User;
import graphql.kickstart.tools.GraphQLMutationResolver;
import infrastructure.persistence.adapters.UserService;
import infrastructure.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMutationResolver implements GraphQLMutationResolver {
    private final UserService userService;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public UserMutationResolver(UserService userService) {
        this.userService = userService;
    }

    ///Mutations/////////////////////////////////////////////////////////////////
    public User createUser(UserInput userInput) {
        User user = userMapper.inputToDomain(userInput);
        return userService.createUser(user);
    }

    public User updateUser(final long id, UserInput userInput) {
        User user = userMapper.inputToDomain(userInput);
        return userService.updateUser(id, user);
    }

    public boolean deleteUser(final long id) {
        return userService.deleteUser(id);
    }
}
