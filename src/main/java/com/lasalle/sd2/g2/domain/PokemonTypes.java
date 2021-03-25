package com.lasalle.sd2.g2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PokemonTypes implements Serializable {

    private static final long serialVersionUID = 7776157874263938718L;

    private List<String> types = new ArrayList<>();

    public PokemonTypes() {
        //Default constructor
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public void addType(String type) {
        this.types.add(type);
    }
}
