package com.lasalle.sd2.g2.pokemons.application.dto;

import java.io.Serializable;
import java.util.List;

public class PokemonDetailsResponse implements Serializable {

    private static final long serialVersionUID = 4057350344147926615L;

    private final Integer id;
    private final String name;
    private final List<String> types;

    public PokemonDetailsResponse(Integer id, String name, List<String> types) {
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
