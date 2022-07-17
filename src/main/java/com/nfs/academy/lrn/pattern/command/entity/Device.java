package com.nfs.academy.lrn.pattern.command.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Device implements Serializable {

    private int status;
    private int volumeLevel;
    private int currentChannel;
    private Set<Integer> favourites;

//    private ICommand command;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getVolumeLevel() {
        return volumeLevel;
    }

    public void setVolumeLevel(int volumeLevel) {
        this.volumeLevel = volumeLevel;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(int currentChannel) {
        this.currentChannel = currentChannel;
    }

    public Set<Integer> getFavourites() {
        return favourites;
    }

    public void setFavourites(Set<Integer> favourites) {
        this.favourites = favourites;
    }

    // removed flow of cmd exec from rx
//    public ICommand getCommand() {
//        return command;
//    }

//    public void setCommand(ICommand command) {
//        this.command = command;
//    }

//    public void consume(ICommand command) {
//        setCommand(command);
//    }

//    public void performOperation(Command type) {
//        getCommand().execute(type, this);
//    }

    public void reset() {
        setStatus(0);
        setVolumeLevel(0);
        setCurrentChannel(0);
        setFavourites(null);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Device{");
        sb.append("status=").append(status);
        sb.append(", volumeLevel=").append(volumeLevel);
        sb.append(", currentChannel=").append(currentChannel);
        sb.append(", favourites=").append(favourites);
        sb.append('}');
        return sb.toString();
    }

    public void powerOn() {
        if (getStatus() == 1) {
            System.out.println("Couldn't perform the given function, Device is already being in ON state");
            return;
        }

        System.out.println("Device has been turned ON successfully");
        setStatus(1);
    }

    public void powerOff() {
        if (getStatus() == 0) {
            System.out.println("Couldn't perform the given function, Device is already being in OFF state");
            return;
        }
        reset();
        System.out.println("Device has been turned OFF successfully");
    }

    public void incChannel() {
        System.out.println("forwarding channel position by 1 unit");
        int currentChannelId = getCurrentChannel();
        setCurrentChannel(++currentChannelId);
    }

    public void decChannel() {
        System.out.println("backing channel position by 1 unit");
        int currentChannelPos = getCurrentChannel();
        setCurrentChannel(--currentChannelPos);
    }

    public void incVolume() {
        System.out.println("incrementing volume by 1 unit");
        int currentVolumeLevel = getVolumeLevel();
        setVolumeLevel(++currentVolumeLevel);
    }

    public void decVolume() {
        System.out.println("decrementing volume by 1 unit");
        int currentVolumeLevel = getVolumeLevel();
        setVolumeLevel(--currentVolumeLevel);
    }

    public void addFavourite() {
        int currentChannel = getCurrentChannel();
        System.out.println("extending the favourites with the channel " + currentChannel);
        Set<Integer> favourites = getFavourites();
        if (favourites == null)
            favourites = new HashSet<>();
        favourites.add(currentChannel);
        setFavourites(favourites);
    }

    public void removeFavourite() {
        int currentChannel = getCurrentChannel();
        Set<Integer> favourites = getFavourites();
        if (favourites == null) {
            System.out.println("unable to remove the given channel "
                    + currentChannel + " from the favourites, since it doesn't exist");
            return;
        }
        boolean succeed = favourites.remove(currentChannel);
        if (!succeed) {
            System.out.println("unable to remove the given channel "
                    + currentChannel + " from the favourites, since it doesn't exist");
            return;
        }
        System.out.println("removing the channel "
                + currentChannel + "from the favourites");
        setFavourites(favourites);

    }
}
