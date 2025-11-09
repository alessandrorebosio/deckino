package it.rebo.deckino.model.impl.action;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

import it.rebo.deckino.model.api.action.Action;

/**
 * Base implementation for peripherals that require a concrete execution step.
 * Provides common functionality for action implementations including value
 * validation and exception handling.
 * 
 * @author Alessandro Rebosio
 * @since 1.0
 */
public abstract class AbstractAction implements Action {

    /** The value parameter for the action execution. */
    private final String value;

    /**
     * Constructs a new AbstractAction with the specified value.
     * Validates that the value is not null and not blank.
     *
     * @param value the value parameter for the action, cannot be null or blank
     * @throws NullPointerException     if the value is null
     * @throws IllegalArgumentException if the value is blank or empty
     */
    public AbstractAction(final String value) {
        this.value = Objects.requireNonNull(value, "Value cannot be null");

        if (value.isBlank()) {
            throw new IllegalArgumentException("Value cannot be blank or empty");
        }
    }

    /**
     * Executes the action, handling any checked exceptions that may occur during
     * execution.
     * This method serves as a template method that delegates to the abstract
     * perform method
     * while providing centralized exception handling.
     */
    @Override
    public void doAction() {
        try {
            perform(this.value);
        } catch (final IOException | URISyntaxException e) {
            throw new IllegalStateException("Launch failed", e);
        }
    }

    /**
     * Performs the specific action implementation.
     * Subclasses must implement this method to provide the actual action logic.
     *
     * @param valueParam the value parameter for the action, guaranteed to be
     *                   non-null and non-blank
     * @throws IOException        if an I/O error occurs during execution
     * @throws URISyntaxException if a string could not be parsed as a URI reference
     */
    protected abstract void perform(String valueParam) throws IOException, URISyntaxException;

}
