package it.rebo.deckino.model.api.peripheral;

/**
 * Represents a device peripheral capable of executing an action.
 * Peripheral implementations define specific behaviors that can be triggered
 * by external events or commands.
 * 
 * @author Alessandro Rebosio
 * @since 1.0
 */
@FunctionalInterface
public interface Peripheral {

    /**
     * Executes the action associated with the peripheral.
     * Implementations define the specific behavior to be performed when the
     * peripheral is activated.
     *
     * @param value the input value or parameter for the peripheral action
     * @throws IllegalArgumentException if the provided value is invalid for the
     *                                  peripheral
     * @throws IllegalStateException    if the peripheral cannot execute in its
     *                                  current state
     */
    void execute(String value);

}
