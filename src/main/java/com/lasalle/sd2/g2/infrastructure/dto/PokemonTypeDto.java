package com.lasalle.sd2.g2.infrastructure.dto;

import java.io.Serializable;
import java.util.Objects;

public class PokemonTypeDto implements Serializable {

    private static final long serialVersionUID = 2638483196131838284L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonTypeDto that = (PokemonTypeDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "PokemonType{" +
            "name='" + name + '\'' +
            '}';
    }
}
