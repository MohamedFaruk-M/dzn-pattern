package com.nfs.academy.lrn.pattern.factory;

import com.nfs.academy.lrn.pattern.command.ChannelImpl;
import com.nfs.academy.lrn.pattern.command.Command;
import com.nfs.academy.lrn.pattern.command.ICommand;
import com.nfs.academy.lrn.pattern.command.PlayListImpl;
import com.nfs.academy.lrn.pattern.command.PowerImpl;
import com.nfs.academy.lrn.pattern.command.VolumeImpl;

public class CommandFactory {

    public static ICommand getImpl(Command type) {
        switch (type) {
            case ON:
            case OFF:
                return new PowerImpl();
            case INCREASE_VOLUME:
            case DECREASE_VOLUME:
                return new VolumeImpl();
            case INCREMENT_CHANNEL:
            case DECREMENT_CHANNEL:
                return new ChannelImpl();
            case ADD_FAVOURITE:
            case REMOVE_FAVOURITE:
                return new PlayListImpl();
            default:
                throw new IllegalArgumentException("Could generate object for the given type: " + type);
        }
    }

}
