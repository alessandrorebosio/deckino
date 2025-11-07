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

}
