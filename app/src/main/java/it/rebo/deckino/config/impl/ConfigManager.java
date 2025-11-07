package it.rebo.deckino.config.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import it.rebo.deckino.config.api.Config;

/**
 * Implementation of the Config interface for managing application configuration
 * files.
 * Handles initialization and provides access to configuration settings.
 * 
 * @author Alessandro Rebosio
 * @since 1.0
 */
public class ConfigManager implements Config {

    private static final Path PATH = Path.of(System.getProperty("user.home"), ".deckino", "config.json");
    private static final String DEFAULT_CONFIG_PATH = "/default-config.json";

    /**
     * Initializes the configuration file on disk.
     * 
     * <p>
     * This method ensures the parent directory for the configured path exists and,
     * if the configuration file does not already exist, copies a default
     * configuration resource from the classpath to the target path.
     *
     * @return true if the configuration is present after the call (either it
     *         already existed or was successfully created from the default
     *         resource); false if the default resource was not found or an I/O
     *         error occurred during initialization
     */
    public static boolean initialize() {
        final Path configDir = PATH.getParent();
        try {
            if (configDir != null) {
                Files.createDirectories(configDir);
            }

            if (Files.notExists(PATH)) {
                try (InputStream in = ConfigManager.class.getResourceAsStream(DEFAULT_CONFIG_PATH)) {
                    if (in == null) {
                        return false;
                    }
                    Files.copy(in, PATH);
                }
            }

            return true;
        } catch (final IOException e) {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<String> port() {
        return this.getRawData("port")
                .filter(JsonElement::isJsonPrimitive)
                .map(JsonElement::getAsString)
                .filter(value -> value != null && !value.isBlank());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Integer> baud() {
        return this.getRawData("baud")
                .filter(JsonElement::isJsonPrimitive)
                .map(JsonElement::getAsInt)
                .filter(value -> value != null && value > 0);
    }

    /**
     * Retrieves the raw JSON element for the specified key from the configuration
     * file. This method reads the configuration file and extracts the JSON element
     * associated with the given key without performing any type conversion or
     * validation.
     *
     * @param key the JSON key to look up in the configuration
     * @return an Optional containing the JsonElement if the key exists and is not
     *         null, empty if the key is not found, the value is null, or an error
     *         occurs during file reading or parsing
     */
    private Optional<JsonElement> getRawData(final String key) {
        try (BufferedReader reader = Files.newBufferedReader(PATH, StandardCharsets.UTF_8)) {
            final JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            final JsonElement element = jsonObject.get(key);

            return Optional.ofNullable(element).filter(el -> !el.isJsonNull());
        } catch (final IOException e) {
            return Optional.empty();
        }
    }

}
