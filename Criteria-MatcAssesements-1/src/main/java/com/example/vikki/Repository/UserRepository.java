package com.example.vikki.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vikki.Model.UserDao;

@Repository
public interface UserRepository extends JpaRepository<UserDao, Long> {
  Optional<UserDao> findByUsername(String username);
  Boolean existsByUsername(String username);
  Boolean existsByEmail(String email);

}