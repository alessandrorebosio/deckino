#include <Arduino.h>
#include <button.h>

#include "config.h"

#define len(arr) (sizeof(arr) / sizeof((arr)[0]))

Button buttons[len(pins)];

void setup() {
    Serial.begin(BAUD);

    for (uint8_t i = 0; i < len(buttons); i++) {
        buttons[i] = Button(pins[i]);
        pinMode(buttons[i].pin, INPUT_PULLUP);
    }
    Serial.println("streamdeck");
}

void loop() {
    for (uint8_t i = 0; i < len(buttons); i++) {
        if (isPressed(buttons[i])) {
            Serial.println(String("btn:") + i);
        }
    }
}
