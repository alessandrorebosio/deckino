package it.rebo.deckino.model.impl;

import it.rebo.deckino.model.api.Model;

public class AppModel implements Model {

    private volatile boolean running;

    @Override
    public boolean isRunning() {
        return this.running;
    }

    @Override
    public void start() {
        this.running = Boolean.TRUE;
    }

    @Override
    public void stop() {
        this.running = Boolean.FALSE;
    }

}
