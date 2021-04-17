package com.lasalle.sd2.g2.users.domain;

public class Pokemon {

    private final Integer id;

    private Pokemon(Integer id) {
        this.id = id;
    }

    public static Pokemon create(Integer id) {
        return new Pokemon(id);
    }

    public Integer getId() {
        return id;
    }
}
