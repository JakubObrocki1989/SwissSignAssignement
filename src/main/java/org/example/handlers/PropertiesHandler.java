package org.example.handlers;

import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler {
    static boolean instance = false;

    public static Properties getProperties() {
        if (instance = true) {
            return properties;
        } else {
            return loadProperties();
        }
    }

    @SneakyThrows
    private static Properties loadProperties() {
        properties = new Properties();
        try (InputStream input = PropertiesHandler.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("Nie znaleziono pliku config.properties");
            }
            properties.load(input);
        }
        return properties;
    }

    static Properties properties = loadProperties();


}
