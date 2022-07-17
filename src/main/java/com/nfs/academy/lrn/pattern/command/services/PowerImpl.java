package com.nfs.academy.lrn.pattern.command.services;

import com.nfs.academy.lrn.pattern.command.util.Command;
import com.nfs.academy.lrn.pattern.command.entity.Device;

public class PowerImpl implements ICommand {

    @Override
    public Device execute(Command type, Device device) {
        switch (type) {
            case ON:
                device.powerOn();
                return device;
            case OFF:
                device.powerOff();
                return device;
            default:
                throw new IllegalArgumentException("Couldn't find relevant operation for the given type: " + type);
        }
    }

}
