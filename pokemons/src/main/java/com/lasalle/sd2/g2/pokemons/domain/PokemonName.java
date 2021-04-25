package com.lasalle.sd2.g2.pokemons.domain;

import java.util.Objects;

public class PokemonName {

    private final String name;

    public PokemonName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonName that = (PokemonName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
