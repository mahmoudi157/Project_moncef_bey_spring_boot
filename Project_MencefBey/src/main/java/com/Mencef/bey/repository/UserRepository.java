package com.Mencef.bey.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Mencef.bey.document.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
