package com.example.fotowettbewerb;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sterne")
public class Sterne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate ratingDate;

    @ManyToOne
    @JoinColumn(name = "foto_id", nullable = false)
    private Fotos foto;

    @ManyToOne
    @JoinColumn(name ="user_id", nullable = false)
    private Users user;
}
