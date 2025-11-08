package it.rebo.deckino.model.impl.peripheral;

import java.io.IOException;
import java.util.Objects;

import it.rebo.deckino.model.api.peripheral.Peripheral;

/**
 * Base implementation for peripherals that require a concrete execution step.
 * 
 * @author Alessandro Rebosio
 * @since 1.0
 */
public abstract class AbstractPeripheral implements Peripheral {

    /**
     * Executes the peripheral action after validating the input value.
     * Provides standardized exception handling by converting {@link IOException}
     * to {@link IllegalStateException}.
     *
     * @param value the input value for the peripheral action, must not be null or
     *              blank
     * @throws IllegalArgumentException if the value is null or blank
     * @throws IllegalStateException    if the peripheral action fails due to an I/O
     *                                  error
     */
    @Override
    public void execute(final String value) {
        try {
            perform(value);
        } catch (final IOException e) {
            throw new IllegalStateException("Launch fail", e);
        }
    }

    /**
     * Performs the concrete action of the peripheral.
     * Implementations define the specific behavior to be executed when the
     * peripheral is activated.
     *
     * @param value the validated input value for the peripheral action, guaranteed
     *              to be non-null and non-blank
     * @throws IOException              if an I/O error occurs during peripheral
     *                                  execution
     * @throws IllegalArgumentException if the value format is invalid for the
     *                                  specific peripheral
     */
    protected void perform(final String value) throws IOException {
        Objects.requireNonNull(value, "Value cannot be null");

        if (value.isBlank()) {
            throw new IllegalArgumentException("Value cannot be blank or empty");
        }
    }

}
