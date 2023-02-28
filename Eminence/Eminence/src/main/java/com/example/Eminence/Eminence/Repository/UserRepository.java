package com.example.Eminence.Eminence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    com.example.Eminence.Eminence.Entity.User findByUsername(String username);

    Optional<Object> findByEmail(String email);
}

