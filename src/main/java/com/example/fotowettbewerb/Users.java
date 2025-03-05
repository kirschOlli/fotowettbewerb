package com.example.fotowettbewerb;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private LocalDate registrationDate;
    @Column(nullable = false)
    private LocalDate birthday;


}
