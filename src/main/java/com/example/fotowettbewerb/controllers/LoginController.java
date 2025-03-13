package com.example.fotowettbewerb.controllers;

import com.example.fotowettbewerb.Users;
import com.example.fotowettbewerb.repositories.UsersRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final UsersRepository usersRepository;

    public LoginController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, HttpSession session) {
        Users user = usersRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Benutzer nicht gefunden"));

        // Benutzer in der Session speichern
        session.setAttribute("loggedInUser", user);

        return "redirect:/fotos"; // Weiterleitung zur Foto-Bewertungsseite
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Session löschen
        return "redirect:/"; // Zurück zur Startseite
    }
}
