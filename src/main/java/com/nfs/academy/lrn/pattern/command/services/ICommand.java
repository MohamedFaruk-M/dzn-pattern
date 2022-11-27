package com.nfs.academy.lrn.pattern.command.services;

import com.nfs.academy.lrn.pattern.command.entity.Device;
import com.nfs.academy.lrn.pattern.command.util.Command;

public interface ICommand {

    /**
     * derive the traditional command pattern exec() with no-args
     */
    void execute();

    // execute the given command on to the given device
    // and return the mutated obj
    @Deprecated
    Device execute(Command type, Device device);

}
