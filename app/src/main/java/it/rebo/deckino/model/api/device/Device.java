package it.rebo.deckino.model.api.device;

/**
 * Interface representing a physical device that can be connected and managed.
 * Provides methods for connection management and device interaction.
 * 
 * @author Alessandro Rebosio
 * @since 1.0
 */
public interface Device {

    /**
     * Ensures the device is connected and active.
     * Checks the current connection status and reconnects if necessary.
     *
     * @return true if the device is connected and responsive, false otherwise
     */
    boolean ensureConnection();

    /**
     * Disconnects from the device and releases resources.
     *
     * @return true if disconnection was successful, false otherwise
     */
    boolean disconnect();

    /**
     * Notifies the device to perform an action or update its state.
     * Implementation should define the specific action to be taken.
     */
    void notifyAction();

    /**
     * Checks if the device port is available for connection.
     *
     * @return true if the port is available, false otherwise
     */
    boolean isPortAvailable();

}
