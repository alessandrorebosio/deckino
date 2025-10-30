package it.rebo.deckino.view.impl;

import java.awt.event.WindowEvent;
import java.io.Serial;

import javax.swing.JFrame;

import it.rebo.deckino.view.api.View;

/**
 * Simple Swing-based view used by the application.
 *
 * <p>
 * Creates a small window titled by {@link #TITLE}.
 * </p>
 *
 * @since 1.0
 */
public class AppView extends JFrame implements View {

    public static final String TITLE = "deckino";

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Create and show the application window.
     */
    public AppView() {
        super(TITLE);

        super.setLocationRelativeTo(null);
        super.setVisible(true);
        super.pack();
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * Posts a window-closing event and disposes the frame to release UI
     * resources.
     * </p>
     */
    @Override
    public void close() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        this.dispose();
    }

}
