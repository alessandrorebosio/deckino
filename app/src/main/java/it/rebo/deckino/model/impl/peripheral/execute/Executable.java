package it.rebo.deckino.model.impl.peripheral.execute;

import java.io.IOException;
import java.util.Locale;

import it.rebo.deckino.model.impl.peripheral.AbstractPeripheral;

/**
 * Peripheral that launches an executable located at a given file system path.
 * 
 * @author Alessandro Rebosio
 * @since 1.0
 */
public class Executable extends AbstractPeripheral {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void perform(final String value) throws IOException {
        super.perform(value);
        this.buildLauncher(value).start();
    }

    /**
     * Builds the platform-specific process launcher.
     *
     * @param path the target executable path
     * @return a process builder configured to launch the executable
     */
    private ProcessBuilder buildLauncher(final String path) {
        if (System.getProperty("os.name").toLowerCase(Locale.getDefault()).contains("mac")) {
            return new ProcessBuilder("open", path);
        }
        return new ProcessBuilder(path);
    }

}
