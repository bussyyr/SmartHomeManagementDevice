package domain.models.action;

import domain.models.device.Device;

//is doppelte Code???
public class TurnOnAction implements Action{
    @Override
    public void execute(Device device) {
        device.turnOn();
    }
}
