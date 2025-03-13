package com.example.fotowettbewerb;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
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

    @OneToMany(mappedBy = "user")
    private List<Fotos> fotosList;

    //Standard Konstruktor
    public Users() {
        this.registrationDate = LocalDate.now();
    }

    //getter und setter
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

}
