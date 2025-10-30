package it.rebo.deckino.model.api;

/**
 * Application state holder and business logic facade.
 *
 * <p>
 * The model exposes the running state and allows transitioning to a stopped
 * state.
 * </p>
 *
 * @since 1.0
 */
public interface Model {

    /**
     * Indicates whether the application is currently running.
     *
     * @return {@code true} if running; {@code false} if stopped
     */
    boolean isRunning();

    /**
     * Transition the model to the stopped state, releasing resources if needed.
     *
     * <p>
     * Implementations should be idempotent.
     * </p>
     */
    void stop();

}
