package it.rebo.deckino.config.api;

import java.util.Optional;

/**
 * Interface for configuration management operations.
 * Provides methods to access serial communication settings.
 * 
 * @author Alessandro Rebosio
 * @since 1.0
 */
public interface Config {

    /**
     * Retrieves the serial port name from the configuration.
     *
     * @return an Optional containing the port name if configured and valid,
     *         empty otherwise
     */
    Optional<String> port();

    /**
     * Retrieves the baud rate from the configuration.
     *
     * @return an Optional containing the baud rate if configured and valid,
     *         empty otherwise
     */
    Optional<Integer> baud();

    /**
     * Retrieves the value of a specific peripheral button from the configuration.
     * 
     * <p>
     * This method looks up the specified button identifier in the peripheral
     * configuration
     * and returns its associated value if present and valid.
     * </p>
     *
     * @param id the identifier of the button to retrieve (e.g., "btn:0",
     *           "btn:1")
     * @return an Optional containing the button value if the button exists and has
     *         a non-blank value,
     *         empty Optional if the button doesn't exist, has a null value, or has
     *         a blank value
     * @throws NullPointerException if the buttonId parameter is null
     */
    Optional<String> value(String id);

}
