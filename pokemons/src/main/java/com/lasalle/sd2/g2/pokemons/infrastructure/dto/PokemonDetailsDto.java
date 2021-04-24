package com.lasalle.sd2.g2.pokemons.infrastructure.dto;

import com.lasalle.sd2.g2.pokemons.domain.PokemonDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PokemonDetailsDto implements Serializable {

    private static final long serialVersionUID = 3461915671274913667L;

    private Integer id;
    private PokemonSpeciesDto species;
    private List<PokemonTypesInfoDto> types;

    public PokemonDetailsDto() {
        //Default constructor
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSpecies(PokemonSpeciesDto species) {
        this.species = species;
    }

    public void setTypes(List<PokemonTypesInfoDto> types) {
        this.types = types;
    }

    public PokemonDetails getDetails() {
        List<String> typeList = new ArrayList<>();
        types.forEach(typeInfo -> typeList.add(typeInfo.getType().getName()));

        return new PokemonDetails(id, species.getName(), typeList);
    }
}
