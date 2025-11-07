package it.rebo.deckino.view.impl;

import java.awt.event.WindowEvent;
import java.util.Optional;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import it.rebo.deckino.view.api.View;

public class AppView extends JFrame implements View {

    private Optional<Runnable> onClose;

    public AppView() {
        super("deck.ino");

        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        super.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                AppView.this.onClose.ifPresent(Runnable::run);
            }
        });

        super.setLocationRelativeTo(null);
        super.setVisible(true);
        super.pack();
    }

    @Override
    public void setOnClose(final Runnable onClose) {
        this.onClose = Optional.of(onClose);
    }

    @Override
    public void close() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        this.dispose();
    }

}
