package com.nfs.academy.lrn.pattern.factory;

import java.util.HashMap;
import java.util.Map;

import com.nfs.academy.lrn.pattern.command.services.AbstractCommand;
import com.nfs.academy.lrn.pattern.command.services.ChannelImpl;
import com.nfs.academy.lrn.pattern.command.util.Command;
import com.nfs.academy.lrn.pattern.command.services.ICommand;
import com.nfs.academy.lrn.pattern.command.services.PlayListImpl;
import com.nfs.academy.lrn.pattern.command.services.PowerImpl;
import com.nfs.academy.lrn.pattern.command.services.VolumeImpl;

public class CommandFactory {

    /**
     * use an alternative: dynamic version {@link CommandFactory#getDynamicImpl(Command)}
     * @param type
     * @return
     */
    @Deprecated
    public static ICommand getImpl(Command type) {
        switch (type) {
            case ON:
            case OFF:
//                return new PowerImpl();
                return Cache.get(Cache.Key.POWER);
            case INCREASE_VOLUME:
            case DECREASE_VOLUME:
//                return new VolumeImpl();
                return Cache.get(Cache.Key.VOLUME);
            case INCREMENT_CHANNEL:
            case DECREMENT_CHANNEL:
//                return new ChannelImpl();
                return Cache.get(Cache.Key.CHANNEL);
            case ADD_FAVOURITE:
            case REMOVE_FAVOURITE:
//                return new PlayListImpl();
                return Cache.get(Cache.Key.PLAYLIST);
            default:
                throw new IllegalArgumentException("Could generate object for the given type: " + type);
        }
    }

    /**
     * provide the interface which wraps the command in it.
     * @param type
     * @return
     */
    public static ICommand getDynamicImpl(Command type) {
        ICommand command = getImpl(type);
        ((AbstractCommand) command).setType(type);
        return command;
    }

    // caching with flyweight
    private static class Cache {
        static final Map<Key, ICommand> lookup;

        static {
            lookup = new HashMap<>();
            lookup.put(Key.POWER, new PowerImpl());
            lookup.put(Key.VOLUME, new VolumeImpl());
            lookup.put(Key.CHANNEL, new ChannelImpl());
            lookup.put(Key.PLAYLIST, new PlayListImpl());
        }

        private enum Key {
            POWER,
            VOLUME,
            CHANNEL,
            PLAYLIST
        }

        static ICommand get(Key key) {
            return lookup.get(key);
        }
    }

}
