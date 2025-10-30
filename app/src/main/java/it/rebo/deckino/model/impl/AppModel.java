package it.rebo.deckino.model.impl;

import it.rebo.deckino.model.api.Model;

/**
 * Default in-memory model holding a simple running flag.
 *
 * @since 1.0
 */
public class AppModel implements Model {

    private volatile boolean running;

    /**
     * Create a model in the running state.
     */
    public AppModel() {
        this.running = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isRunning() {
        return this.running;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stop() {
        this.running = false;
    }

}
