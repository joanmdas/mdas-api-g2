package com.lasalle.sd2.g2.users.application;

import com.lasalle.sd2.g2.users.domain.User;
import com.lasalle.sd2.g2.users.domain.UsersRepository;

public class CreateUser {

    private final UsersRepository repository;

    public CreateUser(UsersRepository repository) {
        this.repository = repository;
    }

    public User execute() {
        User user = User.create();
        repository.save(user);
        return user;
    }

}
