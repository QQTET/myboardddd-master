package com.example.myboard.repository;

import com.example.myboard.model.Board;
import com.example.myboard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
