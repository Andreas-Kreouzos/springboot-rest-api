package com.andrekreou.springboot.coursetwo.repository;

import com.andrekreou.springboot.coursetwo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
