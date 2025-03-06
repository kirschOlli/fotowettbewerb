package com.example.fotowettbewerb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fotowettbewerb.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
}
