package com.lasalle.sd2.g2.users.domain;

public interface UsersRepository {
    void save(User user);
    User findByUuid(String userId) throws UserNotFoundException;
}
