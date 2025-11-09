package it.rebo.deckino.model.impl.action.execute;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Locale;

import it.rebo.deckino.model.impl.action.AbstractAction;

/**
 * Peripheral that launches an executable located at a given file system path.
 * 
 * @author Alessandro Rebosio
 * @since 1.0
 */
public class Execute extends AbstractAction {

    /**
     * Constructs a new Execute action with the specified value.
     *
     * @param value the file path of the executable to launch
     */
    public Execute(final String value) {
        super(value);
    }

    /**
     * Executes the action by launching the executable at the specified path.
     *
     * @param value the file path of the executable to launch
     * @throws IOException if an I/O error occurs during process execution
     */
    @Override
    protected void perform(final String value) throws IOException, URISyntaxException {
        this.buildLauncher(value).start();
    }

    /**
     * Builds the platform-specific process launcher.
     *
     * @param path the target executable path
     * @return a process builder configured to launch the executable
     */
    private ProcessBuilder buildLauncher(final String path) {
        if (System.getProperty("os.name").toLowerCase(Locale.ROOT).contains("mac")) {
            return new ProcessBuilder("open", path);
        }
        return new ProcessBuilder(path);
    }

}
