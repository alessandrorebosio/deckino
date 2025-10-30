package it.rebo.deckino.view.api;

/**
 * Minimal view interface used by the application to represent a UI.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface View {

    /**
     * Close the view and release UI resources.
     *
     * <p>
     * Implementations should be idempotent.
     * </p>
     */
    void close();

}
