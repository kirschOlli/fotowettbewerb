package com.example.fotowettbewerb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fotowettbewerb.Sterne;

public interface SterneRepository extends JpaRepository<Sterne, Long> {
    int countByFotoId(Long fotoId);
}
