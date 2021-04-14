package com.lasalle.sd2.g2.types.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class PokemonTypes implements Serializable {

    private static final long serialVersionUID = 7776157874263938718L;

    private final List<String> types;

    public PokemonTypes(List<String> types) {
        this.types = types;
    }

    public List<String> getTypes() {
        return types;
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
