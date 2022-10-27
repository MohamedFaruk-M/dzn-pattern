package com.nfs.academy.lrn.pattern.command.services;

import com.nfs.academy.lrn.pattern.command.util.Command;
import com.nfs.academy.lrn.pattern.command.entity.Device;

public class PlayListImpl extends AbstractCommand implements ICommand {

    @Override
    public void execute() {
        delegateExec();
    }

    @Override
    public Device execute(Command type, Device device) {
        this.type = type;
        this.device = device;
        return delegateExec();
    }

    private Device delegateExec() {
        switch (type) {
            case ADD_FAVOURITE:
                device.addFavourite();
                return device;
            case REMOVE_FAVOURITE:
                device.removeFavourite();
                return device;
            default:
                throw new IllegalArgumentException("Couldn't find relevant operation for the given type: " + type);

        }
    }

}
