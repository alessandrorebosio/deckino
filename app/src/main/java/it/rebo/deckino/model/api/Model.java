package it.rebo.deckino.model.api;

/**
 * Interface representing the application model.
 * Defines methods to manage the running state of the application.
 * 
 * @author Alessandro Rebosio
 * @since 1.0
 */
public interface Model {

    /**
     * Checks if the model is currently running.
     *
     * @return true if the model is running, false otherwise
     */
    boolean isRunning();

    /**
     * Starts the model and sets it to running state.
     */
    void start();

    /**
     * Ensure the underlying device is connected and responsive.
     */
    void handleDevie();

    /**
     * Stops the model and sets it to not running state.
     */
    void stop();

}
