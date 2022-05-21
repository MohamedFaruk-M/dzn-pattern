package com.nfs.academy.lrn.pattern.command;

import java.util.HashSet;
import java.util.Set;

public class PlayListImpl implements ICommand {
    @Override
    public Device execute(Command type, Device device) {
        switch (type) {
            case ADD_FAVOURITE:
                addFavourite(device);
                return device;
            case REMOVE_FAVOURITE:
                removeFavourite(device);
                return device;
            default:
                throw new IllegalArgumentException("Couldn't find relevant operation for the given type: " + type);

        }
    }

    private void addFavourite(Device device) {
        int currentChannel = device.getCurrentChannel();
        System.out.println("extending the favourites with the channel " + currentChannel);
        Set<Integer> favourites = device.getFavourites();
        if (favourites == null)
            favourites = new HashSet<>();
        favourites.add(currentChannel);
        device.setFavourites(favourites);
    }

    private void removeFavourite(Device device) {
        int currentChannel = device.getCurrentChannel();
        Set<Integer> favourites = device.getFavourites();
        if (favourites == null) {
            System.out.println("unable to remove the given channel " + currentChannel + " from the favourites, since it doesn't exist");
            return;
        }
        boolean succeed = favourites.remove(currentChannel);
        if (!succeed) {
            System.out.println("unable to remove the given channel " + currentChannel + " from the favourites, since it doesn't exist");
            return;
        }
        System.out.println("removing the channel "
                + currentChannel + "from the favourites");
        device.setFavourites(favourites);

    }
}
