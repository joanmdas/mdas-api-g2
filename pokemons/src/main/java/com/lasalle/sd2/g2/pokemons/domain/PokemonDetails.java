package com.lasalle.sd2.g2.pokemons.domain;

import java.io.Serializable;
import java.util.List;

public class PokemonDetails implements Serializable {

    private static final long serialVersionUID = 2748896858029859917L;

    private final Integer id;
    private final String name;
    private final List<String> types;

    public PokemonDetails(Integer id, String name, List<String> types) {
        this.id = id;
        this.name = name;
        this.types = types;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getTypes() {
        return types;
    }
}
