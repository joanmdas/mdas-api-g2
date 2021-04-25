package com.lasalle.sd2.g2.pokemons.infrastructure.repository.pokeapi;

import java.io.Serializable;

public class PokeApiTypeResponse implements Serializable {

    private static final long serialVersionUID = 2638483196131838284L;

    private String name;

    public PokeApiTypeResponse() {
        //Default creator needed by feign library
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
