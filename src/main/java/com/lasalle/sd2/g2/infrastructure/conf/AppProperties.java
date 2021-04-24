package com.lasalle.sd2.g2.infrastructure.conf;

import com.lasalle.sd2.g2.pokemons.infrastructure.conf.PokemonsConfiguration;
import com.lasalle.sd2.g2.types.infrastructure.conf.TypesConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {

    private static final Properties APP_PROPERTIES = new Properties();

    private AppProperties() {
        //Default private constructor
    }

    public static void loadAppProperties() throws IOException {
        try (InputStream input = AppProperties.class.getClassLoader().getResourceAsStream("application.properties")) {
            APP_PROPERTIES.load(input);
        }
    }

    public static void sendPropertiesToTypes() {
        TypesConfiguration.setBaseUrl(APP_PROPERTIES.getProperty("pokeapi.baseurl"));
    }

    public static void sendPropertiesToPokemons() {
        PokemonsConfiguration.setBaseUrl(APP_PROPERTIES.getProperty("pokeapi.baseurl"));
    }

    public static String getServerPort() {
        return (String) APP_PROPERTIES.getOrDefault("server.port", "8090");
    }
}
