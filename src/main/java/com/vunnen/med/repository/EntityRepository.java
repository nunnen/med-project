package com.vunnen.med.repository;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public abstract class EntityRepository<T> {
    private final Map<Long, T> repository = new HashMap<>();
    private Long nextId = 1L;

    public T create(T entity) {
        repository.put(nextId++, entity);
        return entity;
    }

    public Optional<T> find(long id) {
        return Optional.ofNullable(repository.get(id));
    }

    public List<T> findAll() {
        return new ArrayList<>(repository.values());
    }

    public void delete(long id) {
        repository.remove(id);
    }


}
