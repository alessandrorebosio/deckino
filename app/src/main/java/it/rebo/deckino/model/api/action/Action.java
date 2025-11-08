package it.rebo.deckino.model.api.action;

import java.util.Locale;
import java.lang.reflect.InvocationTargetException;

/**
 * Represents a device peripheral capable of executing an action.
 * Peripheral implementations define specific behaviors that can be triggered
 * by external events or commands.
 * 
 * @author Alessandro Rebosio
 * @since 1.0
 */
@FunctionalInterface
public interface Action {

    /**
     * Executes the action defined by this peripheral.
     */
    void doAction();

    /**
     * Creates an Action instance based on the specified type and value.
     *
     * @param type  the type of action to create
     * @param value the value parameter for the action
     * @return a new Action instance
     * @throws IllegalArgumentException if the action cannot be created
     */
    static Action of(final String type, final String value) {
        try {
            final Class<?> clazz = Class
                    .forName("it.rebo.deckino.model.impl.action." + type.toLowerCase(Locale.ROOT) + "."
                            + capitalize(type));
            return (Action) clazz.getDeclaredConstructor(String.class).newInstance(value);
        } catch (final ClassNotFoundException | NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }

    /**
     * Capitalizes the first character of a string and converts the rest to
     * lowercase.
     * If the input string is null, empty, or consists of a single character,
     * appropriate handling is applied.
     *
     * @param str the string to capitalize, may be null
     * @return the capitalized string, or the original string if it's null, empty,
     *         or cannot be capitalized
     * @throws StringIndexOutOfBoundsException if the string is empty
     */
    private static String capitalize(final String str) {
        return str.substring(0, 1).toUpperCase(Locale.ROOT) + str.substring(1);
    }

}
