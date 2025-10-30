package it.rebo.deckino.core.api;

/**
 * Core engine responsible for driving the application lifecycle.
 *
 * <p>
 * An engine typically coordinates the controller and the view, running the
 * main loop until a termination condition occurs, and providing a way to stop
 * the application gracefully.
 * </p>
 *
 * @since 1.0
 */
public interface Engine {

    /**
     * Start the engine main loop.
     *
     * <p>
     * Implementations may block the calling thread until the engine is
     * stopped. They should return only after shutdown has been initiated.
     * </p>
     */
    void run();

    /**
     * Stop the engine and trigger a graceful shutdown.
     *
     * <p>
     * Implementations should be idempotent.
     * </p>
     */
    void stop();

}
