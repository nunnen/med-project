package com.vunnen.med.repository;

import com.vunnen.med.model.User;
import com.vunnen.med.util.FakerUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private final Map<Long, User> users;
    private final FakerUtil faker = FakerUtil.getInstance();
    private long id;

    public UserRepository() {
        users = new HashMap<>();
        List<User> users = faker.createFakeUsers(10);
        users.forEach(this::save);
    }

    public void save(User user) {
        id++;
        user.setId(id);
        users.put(id, user);
    }

    public User find(long id) {
        return users.get(id);
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public void delete(long id) {
        users.remove(id);
    }

    public void update(long id, User user) {
        users.put(id, user);
    }
}
