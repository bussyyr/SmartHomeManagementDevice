package infrastructure.adapters;

import infrastructure.persistence.entities.DeviceEntity;
import infrastructure.persistence.entities.UserEntity;
import infrastructure.persistence.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity user){
        return userRepository.save(user);
    }

    public UserEntity updateUser(long id, UserEntity user){
        Optional<UserEntity> existingUserOpt = userRepository.findById(id);
        if(existingUserOpt.isPresent()){
            UserEntity existingUser = existingUserOpt.get();
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setAutomationRules(user.getAutomationRules());
            return userRepository.save(existingUser);
        }else{
            throw new EntityNotFoundException("User with id " + id + " not found!");
        }
    }

    public boolean deleteUser(long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }else{
            throw new EntityNotFoundException("User with id " + id + " not found!");
        }
    }

    public Optional<UserEntity> getUserById(long id){
        return userRepository.findById(id);
    }

    //bu kadar cok get methoduna gerek var mi

    public Optional<UserEntity> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Optional<UserEntity> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    //getDevicesOfUser sikintili

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }
}
