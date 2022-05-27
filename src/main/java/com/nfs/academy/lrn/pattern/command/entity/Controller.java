package com.nfs.academy.lrn.pattern.command.entity;

import com.nfs.academy.lrn.pattern.command.services.ICommand;
import com.nfs.academy.lrn.pattern.command.util.Command;
import com.nfs.academy.lrn.pattern.factory.CommandFactory;

public class Controller {

    private ICommand command;

    public ICommand getCommand() {
        return command;
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void identify(Command type) {
        setCommand(CommandFactory.getImpl(type));
    }

    public ICommand publish() {
        if (command == null)
            throw new IllegalStateException("Couldn't publish the state, before identify");
        return getCommand();
    }
}
