package com.lasalle.sd2.g2.pokemons.infrastructure.repository.pokeapi;

import java.io.Serializable;

public class PokeApiSpeciesResponse implements Serializable {

    private static final long serialVersionUID = -4199536001184342323L;

    private String name;

    public PokeApiSpeciesResponse() {
        //Default constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
