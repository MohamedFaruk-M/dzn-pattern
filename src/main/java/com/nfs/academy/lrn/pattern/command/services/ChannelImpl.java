package com.nfs.academy.lrn.pattern.command.services;

import com.nfs.academy.lrn.pattern.command.util.Command;
import com.nfs.academy.lrn.pattern.command.entity.Device;

public class ChannelImpl implements ICommand {
    @Override
    public Device execute(Command type, Device device) {
        switch (type) {
            case INCREMENT_CHANNEL:
                device.incChannel();
                return device;
            case DECREMENT_CHANNEL:
                device.decChannel();
                return device;
            default:
                throw new IllegalArgumentException("Couldn't find relevant operation for the given type: " + type);

        }
    }

}
