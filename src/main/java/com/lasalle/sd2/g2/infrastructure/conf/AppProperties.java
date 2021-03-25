package com.lasalle.sd2.g2.infrastructure.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {

    private static final Properties APP_PROPERTIES = new Properties();

    private AppProperties() {
        //Default private constructor
    }

    public static void loadAppProperties() throws IOException {
        try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {
            APP_PROPERTIES.load(input);
        }
    }

    public static String getBaseUrl() {
        return APP_PROPERTIES.getProperty("pokeapi.baseurl");
    }
}
