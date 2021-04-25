package com.lasalle.sd2.g2.types.infrastructure.repository.pokeapi;

import java.io.Serializable;

public class PokeApiTypesInfoResponse implements Serializable {

    private static final long serialVersionUID = 1493460659312182259L;

    private PokeApiTypeResponse type;

    public PokeApiTypesInfoResponse() {
        //Default creator needed by feign library
    }

    public PokeApiTypeResponse getType() {
        return type;
    }

    public void setType(PokeApiTypeResponse type) {
        this.type = type;
    }
}
