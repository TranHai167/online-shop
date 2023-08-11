package com.example.myapp.repository;

import com.example.myapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findUserEntityByEmailAndPassword(String email, String password);
    UserEntity findFirstByEmail(String email);
}
