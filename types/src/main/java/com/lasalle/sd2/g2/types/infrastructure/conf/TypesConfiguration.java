package com.lasalle.sd2.g2.types.infrastructure.conf;

public class TypesConfiguration {

    private TypesConfiguration() {
        //Default private constructor
    }

    private static String pokemonTypesBaserUrl;

    public static String getBaseUrl() {
        return pokemonTypesBaserUrl;
    }

    public static void setBaseUrl(String pokeApiBaserUrl) {
        TypesConfiguration.pokemonTypesBaserUrl = pokeApiBaserUrl;
    }
}
