package com.lasalle.sd2.g2.types.application.dto;

import java.io.Serializable;
import java.util.List;

public class PokemonTypesResponse implements Serializable {

    private static final long serialVersionUID = -6717819661401787974L;

    private final List<String> types;

    public PokemonTypesResponse(List<String> types) {
        this.types = types;
    }

    public List<String> getTypes() {
        return types;
    }
}
