package com.nfs.academy.lrn.pattern.command.services;

import com.nfs.academy.lrn.pattern.command.util.Command;
import com.nfs.academy.lrn.pattern.command.entity.Device;

public class VolumeImpl implements ICommand {
    @Override
    public Device execute(Command type, Device device) {

        switch (type) {
            case INCREASE_VOLUME:
                incVolume(device);
                return device;
            case DECREASE_VOLUME:
                decVolume(device);
                return device;
            default:
                throw new IllegalArgumentException("Couldn't find relevant operation for the given type: " + type);

        }

    }

    private void incVolume(Device device) {
        System.out.println("incrementing volume by 1 unit");
        int currentVolumeLevel = device.getVolumeLevel();
        device.setVolumeLevel(++currentVolumeLevel);
    }

    private void decVolume(Device device) {
        System.out.println("decrementing volume by 1 unit");
        int currentVolumeLevel = device.getVolumeLevel();
        device.setVolumeLevel(--currentVolumeLevel);
    }
}
