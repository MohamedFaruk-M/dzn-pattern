package com.nfs.academy.lrn.pattern.command;

import com.nfs.academy.lrn.pattern.command.entity.Controller;
import com.nfs.academy.lrn.pattern.command.entity.Device;
import com.nfs.academy.lrn.pattern.command.util.Command;

public class Person {

    private Controller remote;
    private Device television;

    private void plugPower() {
        remote = new Controller();
        television = new Device();
    }

    private void pressButton(Command button) {
        if (remote == null)
            throw new IllegalStateException("Couldn't perform the desired operation (" + button
                    + ") in IDLE state, please plug on the power to initiate");
        remote.identify(button);

//        television.consume(remote.obtainCtrl());

        System.out.println("\nBefore " + button + " television state: " + television);

//        television.performOperation(button);

        television = remote.publishSgl(television);

        System.out.println("After " + button + " television state: " + television);

    }

    public static void main(String[] args) {
        Person person = new Person();
        person.plugPower();
        person.pressButton(Command.ON);

        person.pressButton(Command.INCREMENT_CHANNEL);

        person.pressButton(Command.INCREASE_VOLUME);

        person.pressButton(Command.INCREASE_VOLUME);

        person.pressButton(Command.INCREMENT_CHANNEL);

        person.pressButton(Command.ADD_FAVOURITE);

        person.pressButton(Command.INCREMENT_CHANNEL);

        person.pressButton(Command.INCREASE_VOLUME);

        person.pressButton(Command.INCREMENT_CHANNEL);

        person.pressButton(Command.REMOVE_FAVOURITE);

        person.pressButton(Command.DECREMENT_CHANNEL);

        person.pressButton(Command.ADD_FAVOURITE);

        person.pressButton(Command.DECREMENT_CHANNEL);

        person.pressButton(Command.REMOVE_FAVOURITE);

        person.pressButton(Command.OFF);

        person.pressButton(Command.ON);

    }

}
