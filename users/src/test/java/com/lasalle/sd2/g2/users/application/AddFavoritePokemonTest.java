package com.lasalle.sd2.g2.users.application;

import com.lasalle.sd2.g2.users.domain.Pokemon;
import com.lasalle.sd2.g2.users.domain.User;
import com.lasalle.sd2.g2.users.domain.UserNotFoundException;
import com.lasalle.sd2.g2.users.domain.UsersRepository;
import com.lasalle.sd2.g2.users.infrastructure.repository.InMemoryUsersRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddFavoritePokemonTest {

    private static UsersRepository repository;
    private static String userId;

    @BeforeAll
    static void beforeAll() {
        repository = new InMemoryUsersRepository();

        CreateUser createUser = new CreateUser(repository);
        userId = createUser.execute();
    }

    @Test
    void executeThrowsUserNotFoundException() {
        AddFavoritePokemon addFavoritePokemon = new AddFavoritePokemon(repository);
        assertThrows(UserNotFoundException.class, () -> addFavoritePokemon.execute("UserNotExists", 1));
    }

    @Test
    void executeAddedSuccessfully() throws UserNotFoundException {
        AddFavoritePokemon addFavoritePokemon = new AddFavoritePokemon(repository);
        addFavoritePokemon.execute(userId, 123);

        User userAdded = repository.findByUuid(userId);

        assertNotNull(userAdded);
        assertTrue(userAdded.getFavorites().getPokemons().contains(Pokemon.create(123)));
    }
}
