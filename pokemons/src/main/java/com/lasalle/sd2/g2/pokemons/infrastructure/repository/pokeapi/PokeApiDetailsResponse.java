package com.lasalle.sd2.g2.pokemons.infrastructure.repository.pokeapi;

import com.lasalle.sd2.g2.pokemons.domain.PokemonDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PokeApiDetailsResponse implements Serializable {

    private static final long serialVersionUID = 3461915671274913667L;

    private Integer id;
    private PokeApiSpeciesResponse species;
    private List<PokeApiTypesResponse> types;

    public PokeApiDetailsResponse() {
        //Default constructor
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSpecies(PokeApiSpeciesResponse species) {
        this.species = species;
    }

    public void setTypes(List<PokeApiTypesResponse> types) {
        this.types = types;
    }

    public PokemonDetails getDetails() {
        List<String> typeList = new ArrayList<>();
        types.forEach(typeInfo -> typeList.add(typeInfo.getType().getName()));

        return new PokemonDetails(id, species.getName(), typeList);
    }
}
