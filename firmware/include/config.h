#ifndef CONFIG_H
#define CONFIG_H

/**
 * @file config.h
 * @brief Global configuration for the firmware
 *
 * This file exposes two main configuration items used by the application:
 * - BAUD: serial communication speed (Serial)
 * - pins: array containing the pin numbers where the buttons are connected
 *
 * The pins in the `pins` array are used with `INPUT_PULLUP` in setup().
 */

#define BAUD 9600

/** @brief Array of pins used for the buttons (INPUT_PULLUP) */
const uint8_t pins[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

#endif