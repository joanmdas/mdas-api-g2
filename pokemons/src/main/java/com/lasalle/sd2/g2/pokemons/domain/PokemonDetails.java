package com.lasalle.sd2.g2.pokemons.domain;

import java.util.List;
import java.util.Objects;

public class PokemonDetails {

    private final PokemonId id;
    private final PokemonName name;
    private final PokemonTypes types;

    public PokemonDetails(Integer id, String name, List<String> types) {
        this.id = new PokemonId(id);
        this.name = new PokemonName(name);
        this.types = new PokemonTypes(types);
    }

    public Integer getId() {
        return id.getId();
    }

    public String getName() {
        return name.getName();
    }

    public List<String> getTypes() {
        return types.getTypes();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonDetails that = (PokemonDetails) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(name, that.name) &&
            Objects.equals(types, that.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, types);
    }
}
