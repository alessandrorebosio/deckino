package it.rebo.deckino.model.impl;

import java.util.Objects;

import it.rebo.deckino.model.api.Model;
import it.rebo.deckino.model.api.device.Device;
import it.rebo.deckino.model.impl.arduino.Arduino;

/**
 * Simple implementation of the Model interface that maintains a running state.
 * Uses volatile keyword to ensure thread-safe visibility of the running flag.
 * 
 * @author Alessandro Rebosio
 * @since 1.0
 */
public class AppModel implements Model {

    private final Device device;

    private volatile boolean running;

    /**
     * Constructs a new AppModel instance with the default Arduino device.
     * This constructor initializes the model using the default Arduino
     * implementation.
     */
    public AppModel() {
        this(new Arduino());
    }

    /**
     * Constructs a new AppModel instance with the specified device.
     * This constructor allows dependency injection for testing or using different
     * device implementations.
     *
     * @param device the device to be used by the application model
     * @throws NullPointerException if the specified device is null
     */
    public AppModel(final Device device) {
        this.device = Objects.requireNonNull(device, "The device cannot be null.");
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
     * Sets the running state to true.
     */
    @Override
    public void start() {
        this.running = Boolean.TRUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleDevie() {
        if (this.device.ensureConnection()) {
            this.device.notifyAction();
        }
    }

    /**
     * {@inheritDoc}
     * Sets the running state to false.
     */
    @Override
    public void stop() {
        this.device.disconnect();
        this.running = Boolean.FALSE;
    }

}
