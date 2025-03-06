package com.example.fotowettbewerb.controllers;

import com.example.fotowettbewerb.Fotos;
import com.example.fotowettbewerb.repositories.FotosRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class FotosController {

    private final FotosRepository fotosRepository;

    public FotosController(FotosRepository fotosRepository) {
        this.fotosRepository = fotosRepository;
    }

   /* @GetMapping("/fotos")
    public String alleFotosAnzeigen(Model model) {
        model.addAttribute("fotos", fotosRepository.findAll());
        return "fotos";
    }*/
    @GetMapping("/fotos")
    public String alleFotosAnzeigen(Model model) {
        Iterable<Fotos> alleFotos = fotosRepository.findAll();

        for (Fotos foto : alleFotos) {
            System.out.println("Geladenes Foto: " + foto.getId() + " - " + foto.getFilePath());
        }

        model.addAttribute("fotos", alleFotos);
        return "fotos";
    }

}
