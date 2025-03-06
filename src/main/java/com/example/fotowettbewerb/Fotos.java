package com.example.fotowettbewerb;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "fotos")
public class Fotos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filePath;

    private LocalDate uploadTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    //Standard Konstruktor
    public Fotos() {

    }
    public Fotos(String filePath,Users user) {
        this.filePath = filePath;
        this.user = user;
    }

    //getter
    public Long getId() {
        return id;
    }

    public String getFilePath() {
        return filePath;
    }

    public LocalDate getUploadTime() {
        return uploadTime;
    }

    public Users getUser() {
        return user;
    }


    //setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setUploadTime(LocalDate uploadTime) {
        this.uploadTime = uploadTime;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}