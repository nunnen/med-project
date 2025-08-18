package com.vunnen.med.repository;

import com.vunnen.med.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends EntityRepository<User> {
    private Long nextId = 1L;

    @Override
    public User create(User user) {
        user.setId(nextId++);
        return super.create(user);
    }
}
