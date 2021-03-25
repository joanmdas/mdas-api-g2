package com.lasalle.sd2.g2.infrastructure.dto;

import java.io.Serializable;
import java.util.Objects;

public class PokemonTypeInfoDto implements Serializable {

    private static final long serialVersionUID = 1493460659312182259L;

    private Integer slot;
    private PokemonTypeDto type;

    public PokemonTypeInfoDto() {
        //Default constructor
    }

    public PokemonTypeInfoDto(Integer slot, PokemonTypeDto type) {
        this.slot = slot;
        this.type = type;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public PokemonTypeDto getType() {
        return type;
    }

    public void setType(PokemonTypeDto type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonTypeInfoDto that = (PokemonTypeInfoDto) o;
        return Objects.equals(slot, that.slot) &&
            Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slot, type);
    }

    @Override
    public String toString() {
        return "PokemonTypeInfo{" +
            "slot=" + slot +
            ", type=" + type +
            '}';
    }
}
