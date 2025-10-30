package it.rebo.deckino.controller.api;

/**
 * Simple lifecycle contract for controllers used by the application.
 *
 * <p>
 * Controllers expose their running state and a way to stop them. Concrete
 * implementations often delegate to a corresponding model.
 * </p>
 *
 * @since 1.0
 */
public interface Controller {

    /**
     * Returns whether this controller is currently running.
     *
     * @return {@code true} when the controller has been started and can process
     *         requests; {@code false} when it is stopped, not yet started, or
     *         has been shut down.
     */
    boolean isRunning();

    /**
     * Stop the controller and release any held resources.
     *
     * <p>
     * Implementations should be idempotent.
     * </p>
     */
    void stop();

}
