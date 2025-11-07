package it.rebo.deckino.controller.impl;

import java.util.Objects;

import it.rebo.deckino.controller.api.Controller;
import it.rebo.deckino.model.api.Model;
import it.rebo.deckino.model.impl.AppModel;

public class AppController implements Controller {

    private final Model model;

    public AppController() {
        this(new AppModel());
    }

    public AppController(final Model model) {
        this.model = Objects.requireNonNull(model, "The model cannot be null.");
    }

    @Override
    public boolean isRunning() {
        return this.model.isRunning();
    }

    @Override
    public void start() {
        this.model.start();
    }

    @Override
    public void stop() {
        this.model.stop();
    }

}
