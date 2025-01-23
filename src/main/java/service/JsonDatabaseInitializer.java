package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import infrastructure.persistence.entities.DeviceEntity;
import infrastructure.persistence.repositories.DeviceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Service
public class JsonDatabaseInitializer {

    private final DeviceRepository deviceRepository;

    public JsonDatabaseInitializer(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Transactional
    public void loadJsonData(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<DeviceEntity> devices = objectMapper.readValue(
                    Paths.get(jsonFilePath).toFile(),
                    new TypeReference<List<DeviceEntity>>() {}
            );
            deviceRepository.saveAll(devices);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load JSON data", e);
        }
    }
}
