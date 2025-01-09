package domain.models.action;

import domain.models.device.Device;

public class TurnOffAction implements Action{
    @Override
    public void execute(Device device) {
        device.turnOff();
    }
}
