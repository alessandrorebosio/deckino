#include "button.h"

bool isPressed(Button &button) {
    int reading = digitalRead(button.pin);
    unsigned long currentTime = millis();

    if (reading != button.rawReading) {
        button.rawReading = reading;
        button.lastTime = currentTime;
    }

    if ((currentTime - button.lastTime) > DEBOUNCE_TIME) {
        if (button.rawReading != button.lastReading) {
            button.lastReading = button.rawReading;
            return button.lastReading == LOW;
        }
    }

    return false;
}
