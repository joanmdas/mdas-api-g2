package com.lasalle.sd2.g2.users.domain;

import java.util.HashSet;
import java.util.Set;

public class FavoritePokemons {

    private final Set<Pokemon> pokemons;

    private FavoritePokemons() {
        pokemons = new HashSet<>();
    }

    public static FavoritePokemons create() {
        return new FavoritePokemons();
    }

    public void add(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }
}
