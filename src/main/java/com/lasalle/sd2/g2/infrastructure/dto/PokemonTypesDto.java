package com.lasalle.sd2.g2.infrastructure.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PokemonTypesDto implements Serializable {

    private static final long serialVersionUID = 7776157874263938718L;

    private List<PokemonTypeInfoDto> types;

    public PokemonTypesDto() {
        //Default constructor
    }

    public PokemonTypesDto(List<PokemonTypeInfoDto> types) {
        this.types = types;
    }

    public List<PokemonTypeInfoDto> getTypes() {
        return types;
    }

    public void setTypes(List<PokemonTypeInfoDto> types) {
        this.types = types;
    }

    public List<String> getPokemonTypes() {
        List<String> typeList = new ArrayList<>();
        types.forEach(typeInfo -> typeList.add(typeInfo.getType().getName()));
        return typeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonTypesDto that = (PokemonTypesDto) o;
        return Objects.equals(types, that.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(types);
    }

    @Override
    public String toString() {
        return "PokemonTypes{" +
            "types=" + types +
            '}';
    }
}
