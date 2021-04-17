package com.lasalle.sd2.g2.users.application;

import com.lasalle.sd2.g2.users.domain.User;
import com.lasalle.sd2.g2.users.domain.UserNotFoundException;
import com.lasalle.sd2.g2.users.domain.UsersRepository;

public class AddFavoritePokemon {

    private final UsersRepository repository;

    public AddFavoritePokemon(UsersRepository repository) {
        this.repository = repository;
    }

    public void execute(String userId, Integer pokemonId) throws UserNotFoundException {
        User user = repository.findByUuid(userId);
        user.addFavoritePokemon(pokemonId);
        repository.save(user);
    }
}
