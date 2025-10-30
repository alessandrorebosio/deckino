package it.rebo.deckino;

import it.rebo.deckino.core.impl.AppEngine;
import it.rebo.deckino.view.impl.AppView;

/**
 * Application entry point.
 *
 * <p>
 * Creates an {@link AppEngine} with a {@link AppView} and starts it.
 * </p>
 *
 * @since 1.0
 */
public final class App {

    private App() {
    }

    /**
     * Starts the application.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        new AppEngine(new AppView()).run();
    }
}
