package it.rebo.deckino.core.impl;

import java.util.Objects;

import it.rebo.deckino.controller.api.Controller;
import it.rebo.deckino.core.api.Engine;
import it.rebo.deckino.view.api.View;

public class AppEngine implements Engine {

    private static final long PERIOD = 100;

    private final Controller controller;
    private final View view;

    public AppEngine(final Controller controller, final View view) {
        this.controller = Objects.requireNonNull(controller, "The controller cannot be null.");
        this.view = Objects.requireNonNull(view, "The view cannot be null.");

        this.view.setOnClose(this.controller::stop);
    }

    @Override
    public void run() {
        this.controller.start();

        while (this.controller.isRunning()) {
            try {
                Thread.sleep(PERIOD);
            } catch (final InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        this.stop();
    }

    @Override
    public void stop() {
        this.view.close();
    }

}
