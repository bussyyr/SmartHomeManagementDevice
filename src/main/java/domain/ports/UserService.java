package domain.ports;

import domain.models.User;
import domain.models.device.Device;

import java.util.List;
import java.util.Optional;

public interface UserService {
    // rückgabetyp User aber nicht void?
    User createUser(User user);
    User updateUser(long id, User user);
    boolean deleteUser(long id);

    Optional<User> getUserById(long id);
    Optional<User> findByEmail(String email);
    List<Device> getDevicesOfUser(long id);

    List<User> getAllUsers();



}
