package com.example.fotowettbewerb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fotowettbewerb.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
