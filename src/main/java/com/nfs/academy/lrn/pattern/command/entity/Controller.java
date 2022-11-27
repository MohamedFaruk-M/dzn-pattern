package com.nfs.academy.lrn.pattern.command.entity;

import com.nfs.academy.lrn.pattern.command.services.AbstractCommand;
import com.nfs.academy.lrn.pattern.command.services.ICommand;
import com.nfs.academy.lrn.pattern.command.util.Command;
import com.nfs.academy.lrn.pattern.factory.CommandFactory;

public class Controller {

//    private Command type;
    private ICommand command;

    public ICommand getCommand() {
        return command;
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

//    public Command getType() {
//        return type;
//    }

//    public void setType(Command type) {
//        this.type = type;
//    }

    /**
     * used to identify the underlying impl. layer against the given <code>type</code>
     *
     * @param type
     */
    public void identify(Command type) {
//        setType(type);
//        setCommand(CommandFactory.getImpl(type));
        setCommand(CommandFactory.getDynamicImpl(type));
    }

    /**
     * publish the {@link Controller#identify(Command) identified command} on the given <code>television</code> device
     *
     * @param television instance on which relevant execution performed
     * @return mutated receiver instance
     */
    public Device publishSgl(Device television) {
//        television = obtainCtrl().execute(getType(), television);
        ICommand command = obtainCtrl();
        ((AbstractCommand) command).setDevice(television);
        command.execute();
        refresh();
        return television;
    }

    public ICommand obtainCtrl() {
        if (command == null)
            throw new IllegalStateException("Couldn't publish the state, before identify");
        return getCommand();
    }

    // clear off the command info after published
    private void refresh(){
//        setType(null);
        setCommand(null);

    }
}
