package it.rebo.deckino;

import it.rebo.deckino.controller.impl.AppController;
import it.rebo.deckino.core.impl.AppEngine;
import it.rebo.deckino.view.impl.AppView;

/**
 * Entry point of the app.
 * 
 * @author Alessandro Rebosio
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
        new AppEngine(new AppController(), new AppView()).run();
    }
}
