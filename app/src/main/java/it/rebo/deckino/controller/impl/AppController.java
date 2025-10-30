package it.rebo.deckino.controller.impl;

import java.util.Objects;

import it.rebo.deckino.controller.api.Controller;
import it.rebo.deckino.model.api.Model;
import it.rebo.deckino.model.impl.AppModel;

/**
 * Application controller that delegates lifecycle operations and state queries
 * to an underlying {@link Model}.
 *
 * @since 1.0
 */
public class AppController implements Controller {

    private final Model model;

    /**
     * Create a controller using a default {@link AppModel} instance.
     */
    public AppController() {
        this(new AppModel());
    }

    /**
     * Create a controller using the provided model.
     *
     * @param model the model to delegate to
     * @throws NullPointerException if {@code model} is {@code null}
     */
    public AppController(final Model model) {
        this.model = Objects.requireNonNull(model, "The model cannot be null");
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * This implementation delegates to the underlying {@link Model}.
     * </p>
     */
    @Override
    public boolean isRunning() {
        return this.model.isRunning();
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * Delegates to {@link Model#stop()} to initiate a graceful shutdown.
     * </p>
     */
    @Override
    public void stop() {
        this.model.stop();
    }

}
