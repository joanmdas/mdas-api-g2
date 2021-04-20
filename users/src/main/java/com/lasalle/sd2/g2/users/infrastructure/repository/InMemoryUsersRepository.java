package com.lasalle.sd2.g2.users.infrastructure.repository;

import com.lasalle.sd2.g2.users.domain.User;
import com.lasalle.sd2.g2.users.domain.UserId;
import com.lasalle.sd2.g2.users.domain.UserNotFoundException;
import com.lasalle.sd2.g2.users.domain.UsersRepository;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUsersRepository implements UsersRepository {

    private static final Map<String, User> USER_MAP = new ConcurrentHashMap<>();

    @Override
    public void save(User user) {
        USER_MAP.put(user.getUserId().toString(), user);
    }

    @Override
    public User findByUserId(UserId userId) throws UserNotFoundException {
        User user = USER_MAP.get(userId.toString());

        if (Objects.isNull(user)) {
            throw new UserNotFoundException("User " + userId + " not found");
        }

        return user;
    }
}
