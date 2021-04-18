package com.lasalle.sd2.g2.users.domain;

public interface UsersRepository {
    void save(User user);
    User findByUserId(UserId userId) throws UserNotFoundException;
}
