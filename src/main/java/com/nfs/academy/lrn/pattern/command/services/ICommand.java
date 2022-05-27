package com.nfs.academy.lrn.pattern.command.services;

import java.io.Serializable;

import com.nfs.academy.lrn.pattern.command.util.Command;
import com.nfs.academy.lrn.pattern.command.entity.Device;

public interface ICommand extends Serializable {

    // execute the given command on to the given device
    // and return the mutated obj
    Device execute(Command type, Device device);

}
