package com.nfs.academy.lrn.pattern.command.services;

import com.nfs.academy.lrn.pattern.command.util.Command;
import com.nfs.academy.lrn.pattern.command.entity.Device;

public class ChannelImpl extends AbstractCommand implements ICommand {

    @Override
    public void execute() {
        delegateExecution();
    }

    @Override
    public Device execute(Command type, Device device) {
        this.type = type;
        this.device = device;
        return delegateExecution();
    }

    private Device delegateExecution(){
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
