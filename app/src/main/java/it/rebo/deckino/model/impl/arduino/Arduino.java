package it.rebo.deckino.model.impl.arduino;

import java.util.Objects;

import it.rebo.deckino.config.api.Config;
import it.rebo.deckino.config.impl.ConfigManager;
import it.rebo.deckino.model.api.device.Device;
import it.rebo.deckino.model.api.serial.Connection;
import it.rebo.deckino.model.impl.peripheral.execute.Executable;
import it.rebo.deckino.model.impl.serial.SerialConnection;

/**
 * Implementation of the Device interface for Arduino devices.
 * Provides functionality to manage connection and communication with Arduino
 * boards
 * through serial communication.
 * 
 * @author Alessandro Rebosio
 * @since 1.0
 */
public class Arduino implements Device {

    private static final int DEFAULT_BAUDRATE = 9600;

    private final Connection connection;
    private final Config configuration;

    /**
     * Constructs a new Arduino instance using the default configuration manager.
     */
    public Arduino() {
        this(new ConfigManager());
    }

    /**
     * Constructs a new Arduino instance with the specified configuration.
     *
     * @param configuration the configuration to use for this Arduino instance
     * @throws NullPointerException if the configuration is null
     */
    public Arduino(final Config configuration) {
        this.configuration = Objects.requireNonNull(configuration, "The configuraion cannot be null.");
        this.connection = new SerialConnection();
    }

    /**
     * Ensures the Arduino device is connected and active.
     * Checks the current connection status and reconnects if necessary.
     *
     * @return true if the device is connected and responsive, false otherwise
     */
    @Override
    public boolean ensureConnection() {
        if (this.connection.isConnected()) {
            if (this.connection.isConnectionActive()
                    && this.configuration.port()
                            .map(port -> !this.connection.isPortSwitched(port))
                            .orElse(false)) {
                return true;
            }

            this.disconnect();
            return false;
        }

        return this.isPortAvailable()
                && this.configuration.port()
                        .map(port -> this.connection.connect(port, this.configuration.baud().orElse(DEFAULT_BAUDRATE)))
                        .orElse(false);
    }

    /**
     * Disconnects from the Arduino device and releases resources.
     *
     * @return true if disconnection was successful, false otherwise
     */
    @Override
    public boolean disconnect() {
        return this.connection.disconnect();
    }

    /**
     * Notifies the Arduino device to perform an action by checking for received
     * messages. Reads any available data from the serial connection and prints it
     * to the standard output. If no data is available, no action is taken.
     */
    @Override
    public void notifyAction() {
        this.connection.receive()
                .flatMap(this.configuration::value)
                .ifPresent(value -> new Executable().execute(value));
    }

    /**
     * Checks if the Arduino device port is available for connection.
     *
     * @return true if the port is available, false otherwise
     */
    @Override
    public boolean isPortAvailable() {
        return this.configuration.port().map(this.connection::isPortAvailable).orElse(false);
    }

}
