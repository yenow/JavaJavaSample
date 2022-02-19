package com.example.javasample.domain;

import com.example.javasample.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(User user) {
        em.persist(user);
        return user.getUserId();
    }

    public User find(Long userId) {
        return em.find(User.class, userId);
    }
}
