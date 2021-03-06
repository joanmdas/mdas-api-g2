package com.lasalle.sd2.g2.pokemons.domain;

import java.util.Objects;

public class PokemonId {

    private final Integer id;

    public PokemonId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonId pokemonId = (PokemonId) o;
        return Objects.equals(id, pokemonId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
