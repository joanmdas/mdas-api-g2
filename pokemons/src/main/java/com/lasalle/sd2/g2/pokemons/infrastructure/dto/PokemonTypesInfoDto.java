package com.lasalle.sd2.g2.pokemons.infrastructure.dto;

import java.io.Serializable;

public class PokemonTypesInfoDto implements Serializable {

    private static final long serialVersionUID = 1493460659312182259L;

    private PokemonTypeDto type;

    public PokemonTypesInfoDto() {
        //Default creator needed by feign library
    }

    public PokemonTypeDto getType() {
        return type;
    }

    public void setType(PokemonTypeDto type) {
        this.type = type;
    }
}
