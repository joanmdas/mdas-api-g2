package com.lasalle.sd2.g2.users.application;

import com.lasalle.sd2.g2.users.domain.*;

import java.util.UUID;

public class AddFavoritePokemon {

    private final UsersRepository repository;

    public AddFavoritePokemon(UsersRepository repository) {
        this.repository = repository;
    }

    public void execute(String userId, Integer pokemonId) throws UserNotFoundException {
        User user = repository.findByUserId(new UserId(UUID.fromString(userId)));
        user.addFavoritePokemon(new Pokemon(pokemonId));
        repository.save(user);
    }
}
