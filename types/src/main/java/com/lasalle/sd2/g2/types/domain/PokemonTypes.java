package com.lasalle.sd2.g2.types.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PokemonTypes {

    private final List<PokemonType> types;

    public PokemonTypes(List<String> types) {
        this.types = new ArrayList<>();
        types.forEach(type -> this.types.add(new PokemonType(type)));
    }

    public List<String> getTypes() {
        List<String> typesString = new ArrayList<>();
        types.forEach(type -> typesString.add(type.getType()));
        return typesString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonTypes that = (PokemonTypes) o;
        return Objects.equals(types, that.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(types);
    }
}
