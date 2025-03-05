package com.example.fotowettbewerb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fotowettbewerb.Fotos;

public interface FotosRepository extends JpaRepository<Fotos, Long> {
}
