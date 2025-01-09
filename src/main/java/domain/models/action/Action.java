package domain.models.action;

import domain.models.device.Device;

public interface Action {
    void execute(Device device);
}
