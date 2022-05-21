package com.nfs.academy.lrn.pattern.command;

import java.io.Serializable;
import java.util.Set;

public class Device implements Serializable {

    private int status;
    private int volumeLevel;
    private int currentChannel;
    private Set<Integer> favourites;

    private ICommand command;

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

    public ICommand getCommand() {
        return command;
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void consume(ICommand command) {
        setCommand(command);
    }

    public void performOperation(Command type) {
        getCommand().execute(type, this);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
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
}
