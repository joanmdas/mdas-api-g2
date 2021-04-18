package com.lasalle.sd2.g2.users.domain;

import java.util.HashSet;
import java.util.Set;

public class FavoritePokemons {

    private final Set<Pokemon> pokemons;

    public FavoritePokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public static FavoritePokemons create() {
        return new FavoritePokemons(new HashSet<>());
    }

    public void add(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

}
