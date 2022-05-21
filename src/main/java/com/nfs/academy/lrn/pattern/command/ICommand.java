package com.nfs.academy.lrn.pattern.command;

import java.io.Serializable;

public interface ICommand extends Serializable {

    // execute the given command on to the given device
    // and return the mutated obj
    Device execute(Command type, Device device);

}
