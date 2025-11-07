package it.rebo.deckino.view.api;

public interface View {

    void setOnClose(Runnable onClose);

    void close();

}
