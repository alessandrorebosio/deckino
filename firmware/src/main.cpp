#include <Arduino.h>
#include <button.h>

#include "config.h"

/**
 * @file main.cpp
 * @brief Firmware entry point: initialize buttons and emit events
 *
 * Useful macro:
 * - len(arr): compute array length at compile-time
 */

#define len(arr) (sizeof(arr) / sizeof((arr)[0]))

/** @brief Array of Button objects matching the pins defined in config.h */
Button buttons[len(pins)];

/**
 * @brief Initialize serial port and button pins (INPUT_PULLUP)
 */
void setup() {
    Serial.begin(BAUD);

    for (uint8_t i = 0; i < len(buttons); i++) {
        buttons[i] = Button(pins[i]);
        pinMode(buttons[i].pin, INPUT_PULLUP);
    }
    Serial.println("streamdeck");
}

/**
 * @brief Main loop: poll buttons and send events over serial
 *
 * For each button, calls `isPressed` (which handles debounce) and, if true,
 * sends the string "btn:<index>" on Serial.
 */
void loop() {
    for (uint8_t i = 0; i < len(buttons); i++) {
        if (isPressed(buttons[i])) {
            Serial.println(String("btn:") + i);
        }
    }
}
