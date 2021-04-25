package com.lasalle.sd2.g2.types.infrastructure.repository.pokeapi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PokeApiTypesResponse implements Serializable {

    private static final long serialVersionUID = 7776157874263938718L;

    private List<PokeApiTypesInfoResponse> types;

    public PokeApiTypesResponse() {
        //Default creator needed by feign library
    }

    public void setTypes(List<PokeApiTypesInfoResponse> types) {
        this.types = types;
    }

    public List<String> getPokemonTypes() {
        List<String> typeList = new ArrayList<>();
        types.forEach(typeInfo -> typeList.add(typeInfo.getType().getName()));
        return typeList;
    }

}
