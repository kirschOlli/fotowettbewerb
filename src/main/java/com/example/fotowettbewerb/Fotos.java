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


}