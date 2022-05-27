package com.nfs.academy.lrn.pattern.command.services;

import com.nfs.academy.lrn.pattern.command.util.Command;
import com.nfs.academy.lrn.pattern.command.entity.Device;

public class PowerImpl implements ICommand {

    @Override
    public Device execute(Command type, Device device) {
        switch (type) {
            case ON:
                powerOn(device);
                return device;
            case OFF:
                powerOff(device);
                return device;
            default:
                throw new IllegalArgumentException("Couldn't find relevant operation for the given type: " + type);
        }
    }

    private void powerOn(Device device) {
        if (device.getStatus() == 1) {
            System.out.println("Couldn't perform the given function, Device is already being in ON state");
            return;
        }

        System.out.println("Device has been turned ON successfully");
        device.setStatus(1);
    }

    private void powerOff(Device device) {
        if (device.getStatus() == 0) {
            System.out.println("Couldn't perform the given function, Device is already being in OFF state");
            return;
        }
        device.reset();
        System.out.println("Device has been turned OFF successfully");
    }
}
