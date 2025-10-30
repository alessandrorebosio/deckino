package it.rebo.deckino.core.impl;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

import javax.swing.JFrame;

import it.rebo.deckino.controller.api.Controller;
import it.rebo.deckino.controller.impl.AppController;
import it.rebo.deckino.core.api.Engine;
import it.rebo.deckino.view.api.View;

/**
 * Default engine implementation that coordinates controller and view.
 *
 * <p>
 * If the provided {@link View} is also a {@link JFrame}, a window listener is
 * installed to call {@link Controller#stop()} when the window is closing.
 * </p>
 *
 * @since 1.0
 */
public class AppEngine implements Engine {

    private final Controller controller = new AppController();
    private final View view;

    /**
     * Create an engine bound to the given view.
     *
     * @param view the UI view to control
     * @throws NullPointerException if {@code view} is {@code null}
     */
    public AppEngine(final View view) {
        this.view = Objects.requireNonNull(view, "The view cannot be null");

        if (this.view instanceof final JFrame win) {
            win.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(final WindowEvent e) {
                    controller.stop();
                }
            });
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * Runs a simple loop that sleeps periodically while the controller is
     * running; on interruption it terminates and proceeds to {@link #stop()}.
     * </p>
     */
    @Override
    public void run() {
        while (this.controller.isRunning()) {
            try {
                Thread.sleep(100);
            } catch (final InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        this.stop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * Closes the associated view.
     * </p>
     */
    @Override
    public void stop() {
        this.view.close();
    }

}
