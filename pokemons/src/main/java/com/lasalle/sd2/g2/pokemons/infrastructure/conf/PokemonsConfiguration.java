package com.lasalle.sd2.g2.pokemons.infrastructure.conf;

public class PokemonsConfiguration {

    private static String pokemonTypesBaserUrl;

    private PokemonsConfiguration() {
        //Default private constructor
    }

    public static String getBaseUrl() {
        return pokemonTypesBaserUrl;
    }

    public static void setBaseUrl(String pokeApiBaserUrl) {
        PokemonsConfiguration.pokemonTypesBaserUrl = pokeApiBaserUrl;
    }
}
