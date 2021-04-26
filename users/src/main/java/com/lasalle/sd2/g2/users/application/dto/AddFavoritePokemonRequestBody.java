package com.lasalle.sd2.g2.users.application.dto;

import java.io.Serializable;

public class AddFavoritePokemonRequestBody implements Serializable {

    private static final long serialVersionUID = 4849290630331915579L;

    private final Integer pokemonId;

    public AddFavoritePokemonRequestBody(Integer pokemonId) {
        this.pokemonId = pokemonId;
    }

    public Integer getPokemonId() {
        return pokemonId;
    }
}
