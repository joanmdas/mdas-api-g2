package com.lasalle.sd2.g2.users.domain;

import com.lasalle.sd2.g2.users.domain.exceptions.UserNotFoundException;

public interface UsersRepository {
    void save(User user);
    User findByUserId(UserId userId) throws UserNotFoundException;
}
