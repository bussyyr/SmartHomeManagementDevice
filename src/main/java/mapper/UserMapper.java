package mapper;

import application.dto.UserInput;
import domain.models.User;
import infrastructure.persistence.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User entityToDomain(UserEntity entity);
    UserEntity domainToEntity(User domain);

    User inputToDomain(UserInput input);
    UserInput domainToInput(User domain);
}
