#ifndef BUTTON_H
#define BUTTON_H

#include <Arduino.h>

#define DEBOUNCE_TIME 50

struct Button {
    unsigned long lastTime = 0;
    int lastReading = HIGH;
    int rawReading = HIGH;
    uint8_t pin;

    Button(uint8_t p) : pin(p) {}
    Button() : Button(0) {}
};

bool isPressed(Button &button);

#endif