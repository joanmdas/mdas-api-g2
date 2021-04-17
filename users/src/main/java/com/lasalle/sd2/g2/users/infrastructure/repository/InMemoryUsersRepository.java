package com.lasalle.sd2.g2.users.infrastructure.repository;

import com.lasalle.sd2.g2.users.domain.User;
import com.lasalle.sd2.g2.users.domain.UserNotFoundException;
import com.lasalle.sd2.g2.users.domain.UsersRepository;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUsersRepository implements UsersRepository {

    private final Map<String, User> userMap = new ConcurrentHashMap<>();

    @Override
    public void save(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public User findByUuid(String userId) throws UserNotFoundException {
        User user = userMap.get(userId);

        if (Objects.isNull(user)) {
            throw new UserNotFoundException("User " + userId + " not found");
        }

        return user;
    }
}
