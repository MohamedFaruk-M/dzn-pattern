package com.nfs.academy.lrn.pattern.command.services;

import com.nfs.academy.lrn.pattern.command.util.Command;
import com.nfs.academy.lrn.pattern.command.entity.Device;

public class ChannelImpl implements ICommand {
    @Override
    public Device execute(Command type, Device device) {
        switch (type) {
            case INCREMENT_CHANNEL:
                incChannel(device);
                return device;
            case DECREMENT_CHANNEL:
                decChannel(device);
                return device;
            default:
                throw new IllegalArgumentException("Couldn't find relevant operation for the given type: " + type);

        }
    }

    private void incChannel(Device device) {
        System.out.println("forwarding channel position by 1 unit");
        int currentChannelId = device.getCurrentChannel();
        device.setCurrentChannel(++currentChannelId);
    }

    private void decChannel(Device device) {
        System.out.println("backing channel position by 1 unit");
        int currentChannelPos = device.getCurrentChannel();
        device.setCurrentChannel(--currentChannelPos);
    }

}
