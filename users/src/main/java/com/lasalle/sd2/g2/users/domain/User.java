package com.lasalle.sd2.g2.users.domain;

public class User {

    private final UserId id;
    private final FavoritePokemons favorites;

    public User(UserId id, FavoritePokemons pokemons) {
        this.id = id;
        this.favorites = pokemons;
    }

    public static User create() {
        return new User(UserId.create(), FavoritePokemons.create());
    }

    public String getId() {
        return id.getUserId();
    }

    public FavoritePokemons getFavorites() {
        return favorites;
    }

    public void addFavoritePokemon(Integer pokemonId) {
        Pokemon pokemon = Pokemon.create(pokemonId);
        favorites.add(pokemon);
    }
}
