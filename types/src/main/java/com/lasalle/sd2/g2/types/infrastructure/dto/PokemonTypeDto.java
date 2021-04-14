package com.lasalle.sd2.g2.types.infrastructure.dto;

import java.io.Serializable;

public class PokemonTypeDto implements Serializable {

    private static final long serialVersionUID = 2638483196131838284L;

    private String name;

    public PokemonTypeDto() {
        //Default creator needed by feign library
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
