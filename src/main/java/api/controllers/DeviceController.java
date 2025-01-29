package api.controllers;


import infrastructure.api.dto.DeviceInput;
import domain.models.device.Device;
import infrastructure.persistence.adapters.DeviceService;
import infrastructure.persistence.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/devices")
public class DeviceController {

    private final DeviceService deviceService;
    private final DeviceMapper deviceMapper = DeviceMapper.INSTANCE;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable long id) {
        Device device = deviceService.getDeviceById(id);
        if(device == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(device);
    }

    @PostMapping
    public ResponseEntity<Device> createDevice(@RequestBody DeviceInput deviceInput) {
        Device device = deviceMapper.inputToDomain(deviceInput);
        Device createdDevice = deviceService.createDevice(device);
        return ResponseEntity.status(201).body(createdDevice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable long id, @RequestBody DeviceInput deviceInput) {
        Device device = deviceMapper.inputToDomain(deviceInput);
        Device updatedDevice = deviceService.updateDevice(id, device);
        if(updatedDevice == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedDevice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable long id) {
        boolean deleted = deviceService.deleteDevice(id);
        if(!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
