package com.lasalle.sd2.g2.pokemons.infrastructure.repository.pokeapi;

import java.io.Serializable;

public class PokeApiTypesResponse implements Serializable {

    private static final long serialVersionUID = 1493460659312182259L;

    private PokeApiTypeResponse type;

    public PokeApiTypesResponse() {
        //Default creator needed by feign library
    }

    public PokeApiTypeResponse getType() {
        return type;
    }

    public void setType(PokeApiTypeResponse type) {
        this.type = type;
    }
}
