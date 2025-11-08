## Deck.ino

> Deck.ino is a Java + Arduino firmware project that provides the main application (desktop/CLI) and firmware for an Arduino Uno-based device.


This repository contains:

- The `app/` module — Java application source code (main package `it.rebo.deckino`) and configuration resources;
- The `firmware/` folder — PlatformIO project with Arduino firmware (env `uno`);
- [Schematics](./docs/schematic.pdf) — Arduino Uno wiring diagram with push buttons

## Requirements

- Java 21 (used as toolchain in the `app` module)
- Gradle (wrapper included: `./gradlew`)
- PlatformIO Core (to compile/upload the firmware)
- An Arduino Uno (or compatible board) connected via USB to the computer

## Quick Structure

- `app/` — Kotlin Gradle project (plugin `application` + `shadow`) with `it.rebo.deckino.App` class as main
- `firmware/` — PlatformIO project with `platformio.ini` (env: `uno`)

## Configuration and Example Files

- The project includes `app/src/resources/default-config.json` as a default configuration example. This file will be copied to the home directory when the app is first launched, then you can modify it even during runtime to test communication.