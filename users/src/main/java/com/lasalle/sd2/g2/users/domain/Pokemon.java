package com.lasalle.sd2.g2.users.domain;

import java.util.Objects;

public class Pokemon {

    private final Integer id;

    private Pokemon(Integer id) {
        this.id = id;
    }

    public static Pokemon create(Integer id) {
        return new Pokemon(id);
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(id, pokemon.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
