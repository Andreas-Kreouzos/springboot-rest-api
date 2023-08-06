package com.andrekreou.springboot.coursetwo.repository;

import com.andrekreou.springboot.coursetwo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
