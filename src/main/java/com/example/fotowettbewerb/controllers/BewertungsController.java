package com.example.fotowettbewerb.controllers;

import com.example.fotowettbewerb.Fotos;
import com.example.fotowettbewerb.Sterne;
import com.example.fotowettbewerb.Users;
import com.example.fotowettbewerb.repositories.FotosRepository;
import com.example.fotowettbewerb.repositories.SterneRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/bewerten")
public class BewertungsController {

    private final SterneRepository sterneRepository;
    private final FotosRepository fotosRepository;

    public BewertungsController(SterneRepository sterneRepository, FotosRepository fotosRepository) {
        this.sterneRepository = sterneRepository;
        this.fotosRepository = fotosRepository;
    }

    @PostMapping("/{fotoId}")
    public String bewerteFoto(@PathVariable Long fotoId, HttpSession session) {
        Users user = (Users) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login"; // Falls nicht eingeloggt, zum Login umleiten
        }

        Fotos foto = fotosRepository.findById(fotoId)
                .orElseThrow(() -> new RuntimeException("Foto nicht gefunden"));

        // Neue Bewertung speichern
        Sterne stern = new Sterne();
        stern.setUser(user);
        stern.setFoto(foto);
        stern.setRatingDate(LocalDate.now());
        sterneRepository.save(stern);

        return "redirect:/fotos"; // Zurück zur Fotoliste
    }
}
