package it.rebo.deckino.model.impl.action.openurl;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import it.rebo.deckino.model.impl.action.AbstractAction;

/**
 * Action implementation that opens a URL in the system's default web browser.
 * This action uses the Java Desktop API to launch the default browser with the
 * specified URL.
 * 
 * <p>
 * <b>Usage Example:</b>
 * 
 * <pre>
 * {@code
 * OpenUrl openUrl = new OpenUrl("https://www.example.com");
 * openUrl.doAction(); // Opens the URL in default browser
 * }
 * </pre>
 * 
 * <p>
 * <b>Platform Support:</b>
 * The Desktop API is supported on most modern desktop operating systems
 * including
 * Windows, macOS, and Linux with appropriate desktop environments.
 * 
 * @author Alessandro Rebosio
 * @since 1.0
 */
public class OpenUrl extends AbstractAction {

    /**
     * Constructs a new OpenUrl action with the specified URL.
     * The URL will be opened in the system's default web browser when the action is
     * executed.
     *
     * @param value the URL to open, must be a valid HTTP/HTTPS URL and cannot be
     *              null or blank
     * @throws NullPointerException     if the value is null
     * @throws IllegalArgumentException if the value is blank or empty
     */
    public OpenUrl(final String value) {
        super(value);
    }

    /**
     * Opens the specified URL in the system's default web browser.
     * This method uses the Java Desktop API to launch the browser. If the Desktop
     * API is not supported or the BROWSE action is not available, the method will
     * complete silently without throwing an exception.
     *
     * @param valueParam the URL to open, must be a valid HTTP/HTTPS URL
     * @throws IOException        if an I/O error occurs during the browser launch
     *                            process
     * @throws URISyntaxException if the provided URL string cannot be parsed as a
     *                            URI
     * 
     * @see Desktop#isDesktopSupported()
     * @see Desktop#getDesktop()
     * @see Desktop#isSupported(Desktop.Action)
     * @see Desktop#browse(URI)
     */
    @Override
    protected void perform(final String valueParam) throws IOException, URISyntaxException {
        if (Desktop.isDesktopSupported()) {
            final Desktop desktop = Desktop.getDesktop();

            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(new URI(valueParam));
            }
        }
    }

}
