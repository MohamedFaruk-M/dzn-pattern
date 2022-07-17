package com.nfs.academy.lrn.pattern.command.services;

import com.nfs.academy.lrn.pattern.command.util.Command;
import com.nfs.academy.lrn.pattern.command.entity.Device;

public class VolumeImpl implements ICommand {
    @Override
    public Device execute(Command type, Device device) {

        switch (type) {
            case INCREASE_VOLUME:
                device.incVolume();
                return device;
            case DECREASE_VOLUME:
                device.decVolume();
                return device;
            default:
                throw new IllegalArgumentException("Couldn't find relevant operation for the given type: " + type);

        }

    }

}
