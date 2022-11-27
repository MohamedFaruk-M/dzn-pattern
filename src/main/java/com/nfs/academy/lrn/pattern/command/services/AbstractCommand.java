package com.nfs.academy.lrn.pattern.command.services;

import com.nfs.academy.lrn.pattern.command.entity.Device;
import com.nfs.academy.lrn.pattern.command.util.Command;

public class AbstractCommand {
    protected Command type;
    protected Device device;

    public Command getType() {
        return type;
    }

    public void setType(Command type) {
        this.type = type;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
